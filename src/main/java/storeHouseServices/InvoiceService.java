package storeHouseServices;

import java.util.List;

import org.springframework.stereotype.Service;

import storeHouse.Objects.Invoice;
import storeHouseRepositories.InvoiceRepository;

@Service
public class InvoiceService {
	private final InvoiceRepository invoiceRepository;

    public InvoiceService (InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> listarUsuarios() {
        return invoiceRepository.findAll();
    }

    public Invoice guardarUsuario(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public void eliminarUsuario(Long id) {
    	invoiceRepository.deleteById(id);
    }

}
