package storeHouse.base.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import storeHouse.base.entities.ProductInvoice;

public interface ProductInvoiceRepository extends JpaRepository<ProductInvoice, Long>{
	Optional<ProductInvoice> findById(Long id);
}
