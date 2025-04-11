package storeHouse.base.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import storeHouse.base.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByMail(String mail); // Para buscar un usuario por email
}
