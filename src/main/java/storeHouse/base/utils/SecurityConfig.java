package storeHouse.base.utils;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private final JwtFilter jwtFilter;

	public SecurityConfig(JwtFilter jwtFilter) {
		this.jwtFilter = jwtFilter;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(auth -> auth.requestMatchers("/auth/login").permitAll() // Todo el mundo puede
																								// acceder al login
						.requestMatchers("/users/getAll").permitAll() // Cualquiera puede visualizar todos los usuarios
						// - Cuidado!!! Se envian todos los datos del usuario incluso el pass	//Eso si, está encryptado
						
						.requestMatchers("/products/**").permitAll() // Acceso libre a productos
						.anyRequest().hasRole("ADMINISTRADOR") // Todo lo demás requiere rol ADMINISTRADOR
				).exceptionHandling(eh -> eh.authenticationEntryPoint(
						(req, res, ex) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED)));

		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	// Permite utilizar AuthenticationManager.
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	// Encrypta la contraseña
	@Bean
	public PasswordEncoder passwordEncoder() {
		// Usamos BCrypt, las contraseñas en la bbdd tienen que estar hasheadas
		return new BCryptPasswordEncoder();
	}
}
