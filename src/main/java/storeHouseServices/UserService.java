package storeHouseServices;

import org.springframework.stereotype.Service;

import storeHouse.Objects.Users;
import storeHouseRepositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> listarUsuarios() {
        return userRepository.findAll();
    }

    public Users guardarUsuario(Users user) {
        return userRepository.save(user);
    }

    public void eliminarUsuario(Long id) {
        userRepository.deleteById(id);
    }
}
