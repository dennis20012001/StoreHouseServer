package storeHouse.base.controllers;

import storeHouse.base.DTOs.UserDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import storeHouse.base.entities.User;
import storeHouse.base.services.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	/*
	 * API Rest Users: prueba, getAll, getById, create, update y delete
	 */

	private final UserService userService;
	private final PasswordEncoder passwordEncoder;
	
	public UserController(UserService userService, PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}

	// Endpoint de prueba
	@PostMapping("/testUser")
	public void printTestUser() {
		System.out.println("El EndPoint responde.");
	}

	// Obtener lista de usuarios (JSON)
	@GetMapping("/getAll")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	// Obtener usuario por ID
	@GetMapping("/getById/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@PostMapping("/new")
	public ResponseEntity<?> addUser(@RequestBody UserDTO userDTO) {
		try {
			// Convertir el UserDTO a User
			User user = new User();
			user.setName(userDTO.getName());
			user.setImage(userDTO.getImage());
			user.setMail(userDTO.getMail());
			//user.setPass(userDTO.getPass());
			
			// Encriptar el pass
            String password = userDTO.getPass();
            if (password != null && !password.isEmpty()) {
                 String hashedPassword = passwordEncoder.encode(password);
                 user.setPass(hashedPassword);
            } else {
                 // Retornar BAD_REQUEST si el pass esta vacio o nulo
                 return new ResponseEntity<>("La contraseña no puede estar vacía", HttpStatus.BAD_REQUEST);
            }

			// Convertir el rol de String a Enum (Role)
			try {
				User.Role rol = userDTO.getRol(); // El DTO ya tiene el valor de tipo Enum
				user.setRol(rol);
			} catch (IllegalArgumentException e) {
				// Si el rol es inválido
				return new ResponseEntity<>("El rol no es válido", HttpStatus.BAD_REQUEST);
			}

			user.setEnabled(userDTO.getEnabled());

			// Guardar el usuario
			User savedUser = userService.saveUser(user);

			// Retornar la respuesta con el usuario guardado
			return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
		} catch (Exception e) {
			// Si ocurre un error general en el proceso
			return new ResponseEntity<>("Error interno del servidor: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
		User existingUser = userService.getUserById(id);
		if (existingUser != null) {
			existingUser.setName(userDTO.getName());
	        existingUser.setMail(userDTO.getMail());
	        existingUser.setImage(userDTO.getImage());
	        existingUser.setRol(userDTO.getRol());
	        existingUser.setEnabled(userDTO.getEnabled());
	        //existingUser.setPass(userDTO.getPass());

	        // Enriptar el pass solo si hay uno nuevo
            String newPassword = userDTO.getPass();
            if (newPassword != null && !newPassword.isEmpty()) {
                String hashedPassword = passwordEncoder.encode(newPassword);
                existingUser.setPass(hashedPassword);
            }
	        
	        User updatedUser = userService.saveUser(existingUser);
	        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
		}
	}

	// Delete user by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
		User existingUser = userService.getUserById(id);
		if (existingUser != null) {
			userService.deleteUser(id);
			return new ResponseEntity<>("Usuario eliminado correctamente", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
		}
	}

}
