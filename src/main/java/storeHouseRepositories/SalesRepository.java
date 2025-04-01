package storeHouseRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import storeHouse.Objects.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long> {
}

