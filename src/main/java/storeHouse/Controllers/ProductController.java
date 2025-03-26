package storeHouse.Controllers;

import org.springframework.web.bind.annotation.*;

import storeHouse.Objects.Product;

import java.util.List;

import storeHouseServices.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> listarUsuarios() {
        return productService.listarUsuarios();
    }

    @PostMapping
    public Product guardarUsuario(@RequestBody Product product) {
        return productService.guardarUsuario(product);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
    	productService.eliminarUsuario(id);
    }
}
