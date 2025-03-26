package storeHouseServices;

import org.springframework.stereotype.Service;

import storeHouse.Objects.Product;
import storeHouse.Objects.Users;
import storeHouseRepositories.ProductRepository;
import storeHouseRepositories.UserRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listarUsuarios() {
        return productRepository.findAll();
    }

    public Product guardarUsuario(Product product) {
        return productRepository.save(product);
    }

    public void eliminarUsuario(Long id) {
    	productRepository.deleteById(id);
    }
}
