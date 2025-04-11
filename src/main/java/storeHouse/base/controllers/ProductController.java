package storeHouse.base.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import storeHouse.base.DTOs.ProductDTO;
import storeHouse.base.entities.Product;
import storeHouse.base.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	// Endpoint de prueba
	@PostMapping("/testProduct")
	public void printTestProduct() {
		System.out.println("El EndPoint responde.");
	}

	// Obtener lista de productos
	@GetMapping("/getAll")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	// Obtener producto por ID
	@GetMapping("/getById/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}

	@PostMapping("/new")
	public ResponseEntity<?> addProduct(@RequestBody ProductDTO productDTO) {
		try {
			// Convertir el ProductDTO a Product
			Product product = new Product();
			
			product.setName(productDTO.getName());
			product.setAmount(productDTO.getAmount());
			product.setImage(productDTO.getImage());
			product.setMinimumAmount(productDTO.getMinimumAmount());
			product.setSeason(productDTO.getSeason());
			product.setEnabled(productDTO.getEnabled());			
			product.setPrice(productDTO.getPrice());
			product.setSellPrice(productDTO.getSellPrice());
			

			// Guardar el producto
			Product savedProduct = productService.saveProduct(product);

			// Retornar la respuesta con el producto guardado
			return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
		} catch (Exception e) {
			// Si ocurre un error general en el proceso
			return new ResponseEntity<>("Error interno del servidor: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
		Product existingProduct = productService.getProductById(id);
		if (existingProduct != null) {
			existingProduct.setName(productDTO.getName());
			existingProduct.setImage(productDTO.getImage());
			existingProduct.setAmount(productDTO.getAmount());
			existingProduct.setMinimumAmount(productDTO.getMinimumAmount());
			existingProduct.setSeason(productDTO.getSeason());
			existingProduct.setEnabled(productDTO.getEnabled());
			existingProduct.setPrice(productDTO.getPrice());
			existingProduct.setSellPrice(productDTO.getSellPrice());

			Product updatedProduct = productService.saveProduct(existingProduct);
			return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
		}
	}

	// Delete product by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
		Product existingProduct = productService.getProductById(id);
		if (existingProduct != null) {
			productService.deleteProduct(id);
			return new ResponseEntity<>("Producto eliminado correctamente", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
		}
	}
}
