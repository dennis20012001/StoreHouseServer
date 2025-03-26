package storeHouse.Controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import storeHouse.Hibernate.utils.HibernateUtil;
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

    @GetMapping
    public List<ProductInvoice> listarUsuarios() {
        return productInvoiceService.listarUsuarios();
    }

    @PostMapping
    public ProductInvoice guardarUsuario(@RequestBody ProductInvoice productInvoice) {
        return productInvoiceService.guardarUsuario(productInvoice);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
    	productInvoiceService.eliminarUsuario(id);
    }
}
