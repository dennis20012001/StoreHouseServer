package storeHouseRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import storeHouse.Objects.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
