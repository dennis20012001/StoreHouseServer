package storeHouseRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import storeHouse.Objects.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}