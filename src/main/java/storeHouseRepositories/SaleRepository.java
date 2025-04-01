package storeHouseRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import storeHouse.Objects.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}

