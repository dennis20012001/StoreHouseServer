package storeHouse.Controllers;

import org.springframework.web.bind.annotation.*;

import storeHouse.Objects.User;
import storeHouseServices.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	// Get all users
	@GetMapping("/getAll")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	// Get user by id
	@GetMapping("/get/{id}")
	public User getUserById(Long id) {
		return userService.getUserById(id);
	}

	// Save user
	@PostMapping("/save")
	public User saveUser(@RequestBody User users) {
		return userService.saveUser(users);
	}

	// Update user by id
	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	// Delete user by id
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
}
