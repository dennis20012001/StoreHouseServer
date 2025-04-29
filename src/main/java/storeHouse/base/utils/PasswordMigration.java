package storeHouse.base.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import storeHouse.base.entities.User;
import storeHouse.base.repositories.UserRepository;

import java.util.List;

//Esta clase está para hashear las contraseñas que no están hasheadas en la BBDD.

//Para hashear las contrañas no hasheadas de la BBDD lo único que hay que hacer es descomentar //@Component    

//@Component   //Tiene que estar comentado, si no se va a ejecutar siempre y intentará hashear las contraseñas
public class PasswordMigration implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public PasswordMigration(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Iniciando migración de contraseñas...");

        // Obtenemos todos los usuarios
        List<User> users = userRepository.findAll();

        for (User user : users) {
            // Solo se procesan las contraseñas que no están hasheadas.
            
            // BCrypt empieza con $2a$, $2b$ o $2y$, así que comprobamos si lo que hay dentro de la BBDD empieza con esto, si lo hace, significa que ya está hasheado
            if (user.getPass() != null && !user.getPass().startsWith("$2a$") && !user.getPass().startsWith("$2b$") && !user.getPass().startsWith("$2y$")) {
                System.out.println("Encryptando pass de: " + user.getName());

                // Obtenemos el pass sin encriptar
                String plainPassword = user.getPass();

                // Encriptamos el pass
                String hashedPassword = passwordEncoder.encode(plainPassword);
                user.setPass(hashedPassword);
                userRepository.save(user);
                System.out.println("Pass encriptada y guardada en la BBDD: " + user.getName());

            } else if (user.getPass() != null) {
                 System.out.println("Pass del usuario: " + user.getName() + " ya es encriptada. Siguiente.");
            } else {
                 System.out.println("Usuario: " + user.getName() + " no tiene pass. Siguiente.");
            }
        }

        System.out.println("Encriptación de pases terminada.");
    }
}