package storeHouseServices;

import org.springframework.stereotype.Service;

import storeHouse.Objects.Product;
import storeHouseRepositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);;
	}
}
