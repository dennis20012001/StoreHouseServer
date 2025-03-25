package storeHouse.Controllers;

import org.springframework.web.bind.annotation.*;

import storeHouse.Objects.Users;
import storeHouseServices.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Users> listarUsuarios() {
        return userService.listarUsuarios();
    }

    @PostMapping
    public Users guardarUsuario(@RequestBody Users users) {
        return userService.guardarUsuario(users);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        userService.eliminarUsuario(id);
    }
}
