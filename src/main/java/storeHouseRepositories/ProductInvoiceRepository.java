package storeHouseRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import storeHouse.Objects.ProductInvoice;

public interface ProductInvoiceRepository extends JpaRepository<ProductInvoice, Long> {
}