package storeHouseRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import storeHouse.Objects.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
}
