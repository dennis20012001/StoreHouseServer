package storeHouse.base.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import storeHouse.base.entities.Product;
import storeHouse.base.repositories.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	// Obtener todos los productos
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Obtener un producto por ID
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Guardar un nuevo producto
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Eliminar un producto
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
