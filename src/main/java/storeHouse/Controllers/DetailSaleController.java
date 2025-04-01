package storeHouse.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import storeHouse.Objects.Invoice;
import storeHouseServices.InvoiceService;

@RestController
@RequestMapping("/api/detailSale")
public class DetailSaleController {
	private final InvoiceService invoiceService;

	public DetailSaleController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	@GetMapping
	public List<Invoice> listarUsuarios() {
		return invoiceService.listarUsuarios();
	}

	@PostMapping
	public Invoice guardarUsuario(@RequestBody Invoice invoice) {
		return invoiceService.guardarUsuario(invoice);
	}

	@DeleteMapping("/{id}")
	public void eliminarUsuario(@PathVariable Long id) {
		invoiceService.eliminarUsuario(id);
	}

}
