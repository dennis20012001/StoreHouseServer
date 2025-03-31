package storeHouseServices;

import java.util.List;

import org.springframework.stereotype.Service;

import storeHouse.Objects.Invoice;
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

	public List<ProductInvoice> getAllProductInvoice() {
		// TODO Auto-generated method stub
		return null;
	}

	public Invoice getProductInvoiceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Invoice saveProductInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		return null;
	}

	public Invoice updateProductInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteProductInvoice(Long id) {
		// TODO Auto-generated method stub
		
	}

}
