package storeHouseServices;

import java.util.List;

import org.springframework.stereotype.Service;

import storeHouse.Objects.ProductInvoice;
import storeHouseRepositories.ProductInvoiceRepository;

@Service
public class ProductInvoiceService {
	private final ProductInvoiceRepository invoiceDetailsRepository;

    public ProductInvoiceService(ProductInvoiceRepository invoiceDetailsRepository) {
        this.invoiceDetailsRepository = invoiceDetailsRepository;
    }

    public List<ProductInvoice> listarUsuarios() {
        return invoiceDetailsRepository.findAll();
    }

    public ProductInvoice guardarUsuario(ProductInvoice productInvoice) {
        return invoiceDetailsRepository.save(productInvoice);
    }

    public void eliminarUsuario(Long id) {
    	invoiceDetailsRepository.deleteById(id);
    }

}
