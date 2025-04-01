package storeHouse.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import storeHouse.Objects.Sales;
import storeHouseServices.SalesService;

@RestController
@RequestMapping("/api/sale")
public class SalesController {
	private final SalesService SalesService;

	public SalesController(SalesService SalesService) {
		this.SalesService = SalesService;
	}

	@GetMapping
	public List<Sales> listarUsuarios() {
		return SalesService.listarUsuarios();
	}

	@PostMapping
	public Sales guardarUsuario(@RequestBody Sales sales) {
		return SalesService.guardarUsuario(sales);
	}

	@DeleteMapping("/{id}")
	public void eliminarUsuario(@PathVariable Long id) {
		SalesService.eliminarUsuario(id);
	}
}
