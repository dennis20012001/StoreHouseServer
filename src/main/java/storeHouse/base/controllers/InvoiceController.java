package storeHouse.base.controllers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import storeHouse.base.DTOs.InvoiceDTO;
import storeHouse.base.entities.Invoice;
import storeHouse.base.entities.User;
import storeHouse.base.services.InvoiceService;
import storeHouse.base.services.UserService;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

	private final InvoiceService invoiceService;
	private final UserService userService;

	public InvoiceController(InvoiceService invoiceService, UserService userService) {
		this.invoiceService = invoiceService;
		this.userService = userService;
	}

	// Endpoint de prueba
	@PostMapping("/testInvoice")
	public void printTestInvoice() {
		System.out.println("El EndPoint responde.");
	}

	// Obtener lista de invoices
	@GetMapping("/getAll")
	public List<Invoice> getAllInvoices() {
		return invoiceService.getAllInvoices();
	}

	// Obtener invoice por ID
	@GetMapping("/getById/{id}")
	public Invoice getInvoiceById(@PathVariable Long id) {
		return invoiceService.getInvoiceById(id);
	}

	@PostMapping("/new")
	public ResponseEntity<?> addInvoice(@RequestBody InvoiceDTO invoiceDTO) {
		try {
			// Convertir el InvoiceDTO a Invoice
			Invoice invoice = new Invoice();

			invoice.setCIF(invoiceDTO.getCIF());
			invoice.setDate(invoiceDTO.getDate());
			invoice.setPaid(invoiceDTO.isPaid());
			invoice.setTotal(invoiceDTO.getTotal());

			// Obtener el usuario por el ID del DTO
			User user = userService.getUserById(invoiceDTO.getUserId());
			if (user != null) {
				invoice.setUserId(user);
			} else {
				return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
			}

			// Guardar el invoice
			Invoice savedInvoice = invoiceService.saveInvoice(invoice);

			// Retornar la respuesta con el invoice guardado
			return new ResponseEntity<>(savedInvoice, HttpStatus.CREATED);
		} catch (Exception e) {
			// Si ocurre un error general en el proceso
			return new ResponseEntity<>("Error interno del servidor: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateInvoice(@PathVariable Long id, @RequestBody InvoiceDTO invoiceDTO) {
		Invoice existingInvoice = invoiceService.getInvoiceById(id);
		if (existingInvoice != null) {

			existingInvoice.setCIF(invoiceDTO.getCIF());
			existingInvoice.setDate(invoiceDTO.getDate());
			existingInvoice.setPaid(invoiceDTO.isPaid());
			existingInvoice.setTotal(invoiceDTO.getTotal());

			// Obtener el usuario por el ID del DTO
			User user = userService.getUserById(invoiceDTO.getUserId());
			if (user != null) {
				existingInvoice.setUserId(user); 
			} else {
				return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
			}

			Invoice updatedInvoice = invoiceService.saveInvoice(existingInvoice);
			return new ResponseEntity<>(updatedInvoice, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Invoiceo no encontrado", HttpStatus.NOT_FOUND);
		}
	}

	// Delete invoice by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteInvoice(@PathVariable("id") Long id) {
		Invoice existingInvoice = invoiceService.getInvoiceById(id);
		if (existingInvoice != null) {
			invoiceService.deleteInvoice(id);
			return new ResponseEntity<>("Invoice eliminado correctamente", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Invoice no encontrado", HttpStatus.NOT_FOUND);
		}
	}
}
