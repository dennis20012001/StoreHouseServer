package storeHouseServices;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import storeHouse.Objects.Invoice;
import storeHouse.Objects.User;
import storeHouseRepositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Obtiene todos los usuarios.
     * @return Lista de usuarios.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    /**
     * Obtiene un usuario por su ID. Si no existe, devuelve null.
     * @param id Identificador del usuario.
     * @return Usuario encontrado o null si no existe.
     */
    public User getUserById(Long id) {
    	return userRepository.findById(id).orElse(null);
    }

    /**
     * Guarda un nuevo usuario en la base de datos.
     * @param user Usuario a guardar.
     * @return Usuario guardado.
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Actualiza un usuario existente.
     * @param user Usuario con los datos actualizados.
     * @return Usuario actualizado.
     * @throws EntityNotFoundException Si el usuario no existe.
     */
    public User updateUser(User user) {
	    if (!userRepository.existsById(user.getIdUser())) {
	        throw new EntityNotFoundException("Invoice con ID " + user.getIdUser() + " no encontrado.");
	    }
	    return userRepository.save(user);
	}

    /**
     * Elimina un usuario por su ID.
     * @param id Identificador del usuario a eliminar.
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
