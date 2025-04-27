package storeHouse.base.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import storeHouse.base.DTOs.UserLoginResponseDTO;
import storeHouse.base.DTOs.UserLoginDTO;
import storeHouse.base.entities.User;
import storeHouse.base.services.UserService;
import storeHouse.base.utils.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {
	private final UserService userService;
	private final JwtUtil jwtUtil;
	private final AuthenticationManager authenticationManager;

	public AuthController(UserService userService, JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
	    this.userService = userService;
	    this.jwtUtil = jwtUtil;
	    this.authenticationManager = authenticationManager;
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserLoginDTO loginRequest) {
	    try {
	        // Intentar autenticar usando Spring Security
	        Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        loginRequest.getUsername(),
	                        loginRequest.getPassword()
	                )
	        );

	        // Si login correcto, obtener UserDetails
	        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	        
	        String username = userDetails.getUsername(); // Obtener el "username" del UserDetails de Spring Security
            User user = userService.findUserByUsername(username);	//Aver si funciona
	        
	        String token = jwtUtil.generateToken(user); // Generar token con el usuario autenticado
	        return ResponseEntity.ok(new UserLoginResponseDTO(token));

	    } catch (AuthenticationException e) {	// Datos inválidas o usuario no encontrado
	        System.err.println("Fallo de autenticación: " + e.getMessage());
	        return ResponseEntity.status(401).body("Credenciales incorrectas");
	    } catch (Exception e) {
	        System.err.println("Error inesperado durante el login: " + e.getMessage());
	        e.printStackTrace();
	        return ResponseEntity.status(500).body("Error interno del servidor");
	    }
	}
}
