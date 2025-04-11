package storeHouse.base.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import storeHouse.base.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	Optional<Sale> findById(Long id);
}
