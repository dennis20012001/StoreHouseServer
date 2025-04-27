package storeHouse.base.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import storeHouse.base.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByMail(String mail);     

    Optional<User> findByName(String name);

    Optional<User> findByMailOrName(String mail, String name);
    
    Optional<User> findById(Long id);
}