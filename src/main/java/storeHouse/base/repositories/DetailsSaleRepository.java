package storeHouse.base.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import storeHouse.base.entities.DetailsSale;

public interface DetailsSaleRepository extends JpaRepository<DetailsSale, Long>{
	Optional<DetailsSale> findById(Long id);
}
