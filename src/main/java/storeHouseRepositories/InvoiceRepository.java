package storeHouseRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import storeHouse.Objects.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}