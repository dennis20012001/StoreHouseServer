package storeHouse.base.services;

import storeHouse.base.entities.User;
import storeHouse.base.repositories.UserRepository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService{

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Obtener todos los usuarios
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //Obtener usuario por id
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    //Guardar usuario
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    //Borrar usuario por id
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    //Validamos las credenciales del usuario
    public User validarCredenciales(String identificador, String password) {
        Optional<User> userOptional = userRepository.findByMailOrName(identificador, identificador);
        
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPass().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        // Convertir los roles del usuario en una lista de GrantedAuthority
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRol().name()));  // Rol es un enum

        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPass(),
                authorities  // Roles del usuario
        );
    }

    public User findUserByUsername(String username) {
        return userRepository.findByName(username).orElse(null);
    }

}
