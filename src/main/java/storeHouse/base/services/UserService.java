package storeHouse.base.services;

import storeHouse.base.entities.User;
import storeHouse.base.repositories.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Obtener todos los usuarios
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Obtener un usuario por ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Guardar un nuevo usuario
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Eliminar un usuario
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
