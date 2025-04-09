package storeHouse.Controllers;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import storeHouse.Objects.Invoice;
import storeHouse.Objects.User;
import storeHouseServices.InvoiceService;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
	
	private final InvoiceService invoiceService;

	public InvoiceController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	// Get all invoices
	@GetMapping("/getAll")
	public List<Invoice> getAllInvoice() {
		return invoiceService.getAllInvoices();
	}

	// Get invoice by id
	@GetMapping("/get/{id}")
	public Invoice getInvoiceById(Long id) {
		return invoiceService.getInvoiceById(id);
	}

	// Save invoice
	@PostMapping("/save")
	public Invoice saveInvoice(@RequestBody Invoice invoice) {
		return invoiceService.saveInvoice(invoice);
	}

	// Update invoice by id
	@PutMapping("/update")
	public Invoice updateInvoice(@RequestBody Invoice invoice) {
		return invoiceService.updateInvoice(invoice);
	}

	// Delete invoice by id
	@DeleteMapping("/delete/{id}")
	public void deleteInvoice(@PathVariable Long id) {
		invoiceService.deleteInvoice(id);
	}
}
