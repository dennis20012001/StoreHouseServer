package storeHouseServices;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import storeHouse.Objects.Invoice;
import storeHouse.Objects.ProductInvoice;
import storeHouse.Objects.User;
import storeHouseRepositories.InvoiceRepository;

@Service
public class InvoiceService {
	private final InvoiceRepository invoiceRepository;

    public InvoiceService (InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

	public List<Invoice> getAllInvoices() {
		return invoiceRepository.findAll();
	}

	public Invoice getInvoiceById(Long id) {
		return invoiceRepository.findById(id).orElse(null);
	}

	public Invoice saveInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}
	
	public Invoice updateInvoice(Invoice invoice) {
	    if (!invoiceRepository.existsById(invoice.getInvoiceId())) {
	        throw new EntityNotFoundException("Invoice con ID " + invoice.getInvoiceId() + " no encontrado.");
	    }
	    return invoiceRepository.save(invoice);
	}

	public void deleteInvoice(Long id) {
		invoiceRepository.deleteById(id);
	}

}
