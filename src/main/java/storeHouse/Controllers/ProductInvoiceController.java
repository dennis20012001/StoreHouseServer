package storeHouse.Controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import storeHouse.Hibernate.utils.HibernateUtil;
import storeHouse.Objects.Invoice;
import storeHouse.Objects.Product;
import storeHouse.Objects.ProductInvoice;
import storeHouseServices.ProductService;
import storeHouseServices.ProductInvoiceService;

@RestController
@RequestMapping("/api/productInvoice")
public class ProductInvoiceController {
    private final ProductInvoiceService productInvoiceService;

    public ProductInvoiceController(ProductInvoiceService productInvoiceService) {
        this.productInvoiceService = productInvoiceService;
    }
    
 // Get all productInvoice
 	@GetMapping("/getAll")
 	public List<ProductInvoice> getAllProductInvoice() {
 		return productInvoiceService.getAllProductInvoice();
 	}

 	// Get productInvoice by id
 	@GetMapping("/get/{id}")
 	public Invoice getInvoiceById(Long id) {
 		return productInvoiceService.getProductInvoiceById(id);
 	}

 	// Save productInvoice
 	@PostMapping("/save")
 	public Invoice saveInvoice(@RequestBody Invoice invoice) {
 		return productInvoiceService.saveProductInvoice(invoice);
 	}

 	// Update productInvoice by id
 	@PutMapping("/update")
 	public Invoice updateInvoice(@RequestBody Invoice invoice) {
 		return productInvoiceService.updateProductInvoice(invoice);
 	}

 	// Delete productInvoice by id
 	@DeleteMapping("/delete/{id}")
 	public void deleteInvoice(@PathVariable Long id) {
 		productInvoiceService.deleteProductInvoice(id);
 	}
}
