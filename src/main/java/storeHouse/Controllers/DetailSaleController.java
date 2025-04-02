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

import storeHouse.Objects.DetailSale;
import storeHouse.Objects.Invoice;
import storeHouseServices.DetailSaleService;

@RestController
@RequestMapping("/api/detailSale")
public class DetailSaleController {
	private final DetailSaleService detailSaleService;

	public DetailSaleController(DetailSaleService detailSaleService) {
		this.detailSaleService = detailSaleService;
	}

	// Get all detailSales
	@GetMapping("/getAll")
	public List<DetailSale> getAllDetailSales() {
		return detailSaleService.getAllDetailSales();
	}

	// Get detailSale by id
	@GetMapping("/get/{id}")
	public DetailSale getDetailSaleById(Long id) {
		return detailSaleService.getDetailSaleById(id);
	}

	// Save detailSale
	@PostMapping("/save")
	public DetailSale saveDetailSale(@RequestBody DetailSale detailSale) {
		return detailSaleService.saveDetailSale(detailSale);
	}

	// Update detailSale by id
	@PutMapping("/update")
	public DetailSale updateDetailSale(@RequestBody DetailSale detailSale) {
		return detailSaleService.updateDetailSale(detailSale);
	}

	// Delete detailSale by id
	@DeleteMapping("/delete/{id}")
	public void deleteDetailSale(@PathVariable Long id) {
		detailSaleService.deleteDetailSale(id);
	}
}
