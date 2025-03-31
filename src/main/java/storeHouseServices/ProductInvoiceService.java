package storeHouseServices;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import storeHouse.Objects.Invoice;
import storeHouse.Objects.ProductInvoice;
import storeHouseRepositories.ProductInvoiceRepository;

@Service
public class ProductInvoiceService {
	private final ProductInvoiceRepository invoiceDetailsRepository;

    public ProductInvoiceService(ProductInvoiceRepository invoiceDetailsRepository) {
        this.invoiceDetailsRepository = invoiceDetailsRepository;
    }

	public List<ProductInvoice> getAllProductInvoice() {
		return invoiceDetailsRepository.findAll();
	}

	public ProductInvoice getProductInvoiceById(Long id) {
		return invoiceDetailsRepository.findById(id).orElse(null);
	}

	public ProductInvoice saveProductInvoice(ProductInvoice productInvoice) {
		return invoiceDetailsRepository.save(productInvoice);
	}

	public ProductInvoice updateProductInvoice(ProductInvoice productInvoice) {
	    if (!invoiceDetailsRepository.existsById(productInvoice.getDetailId())) {
	        throw new EntityNotFoundException("ProductInvoice con ID " + productInvoice.getDetailId() + " no encontrado.");
	    }
	    return invoiceDetailsRepository.save(productInvoice);
	}

	public void deleteProductInvoice(Long id) {
		invoiceDetailsRepository.deleteById(id);
	}

}
