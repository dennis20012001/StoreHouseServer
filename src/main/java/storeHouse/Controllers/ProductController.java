package storeHouse.Controllers;

import org.springframework.web.bind.annotation.*;

import storeHouse.Objects.Product;

import java.util.List;

import storeHouseServices.ProductService;
import storeHouseServices.UserService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	// Get all products
	@GetMapping("/getAll")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	// Get product by id
	@GetMapping("/get/{id}")
	public Product getProductById(Long id) {
		return productService.getProductById(id);
	}

	// Save product
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	// Update user by id
	@PutMapping("/update")
	public Product updateProduct(Product product) {
		return productService.updateProduct(product);
	}
	
	// Delete product by id
	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
}
