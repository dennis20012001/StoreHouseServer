package storeHouse.base.utils;

import storeHouse.base.entities.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import jakarta.annotation.PostConstruct;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets; // Para convertir la clave String a bytes
import java.util.Date;

@Component
public class JwtUtil {
	//Esta clave tiene que ser larga, si no, no funciona
    private String secretString = "LucianLucianLucianLucianLucianLucianLucianLucianLucianLucianLucia";
    							   

    private SecretKey secretKey;

    @PostConstruct
    public void init() {
        try {
            // Generamos la clave
            this.secretKey = Keys.hmacShaKeyFor(secretString.getBytes(StandardCharsets.UTF_8));
            System.out.println("JwtUtil: SecretKey generada correctamente.");
        } catch (Exception e) {
        	// Para depurar bugs
            System.err.println("JwtUtil: ---- ERROR AL INICIALIZAR SECRETKEY ----");
            System.err.println("JwtUtil: Mensaje de error: " + e.getMessage());
            e.printStackTrace();
            System.err.println("JwtUtil: ---------------------------------------");
        }
    }

    public String generateToken(User user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 1000 * 60 * 10); 	//Token valido solo durante 10 minutos

        return Jwts.builder()
                .subject(user.getName()) //user.getUserId().toString() Antes
                .claim("role", user.getRol().name())  
                .issuedAt(now)                        
                .expiration(expiryDate)               
                .signWith(secretKey, Jwts.SIG.HS256)  
                .compact();                          
    }

    private Claims parseClaims(String token) throws JwtException {
        return Jwts.parser()
                   .verifyWith(secretKey)
                   .build()              
                   .parseSignedClaims(token)
                   .getPayload();      
    }

    public Claims getClaims(String token) {
       return parseClaims(token);
    }

    public String getUserId(String token) {
        return parseClaims(token).getSubject();
    }

    public boolean isValid(String token) {
        try {
            parseClaims(token);
            return true;
        } catch (ExpiredJwtException e) {
            System.err.println("Token expirado: " + e.getMessage());
            return false;
        } catch (UnsupportedJwtException e) {
            System.err.println("Token no soportado: " + e.getMessage());
            return false;
        } catch (MalformedJwtException e) {
            System.err.println("Token mal formado: " + e.getMessage());
            return false;
        } catch (SignatureException e) {
            System.err.println("Error en la firma del token: " + e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            System.err.println("Argumento ilegal en el token: " + e.getMessage());
            return false;
        } catch (JwtException e) {
             System.err.println("Token inválido: " + e.getMessage());
             return false;
        }
    }

    public boolean isExpired(String token) {
        try {
            return parseClaims(token).getExpiration().before(new Date());
        } catch (ExpiredJwtException e) {
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
    
    public String getUsernameFromToken(String token) {
        return parseClaims(token).getSubject(); 
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUserId(token);
        return (username.equals(userDetails.getUsername()) && !isExpired(token));
    }
}