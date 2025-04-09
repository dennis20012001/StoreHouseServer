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
import storeHouse.Objects.Sale;
import storeHouseServices.SaleService;

@RestController
@RequestMapping("/api/sale")
public class SaleController {
	private final SaleService saleService;

	public SaleController(SaleService saleService) {
		this.saleService = saleService;
	}
	
	// Get all sales
		@GetMapping("/getAll")
		public List<Sale> getAllSales() {
			return saleService.getAllSales();
		}

		// Get sale by id
		@GetMapping("/get/{id}")
		public Sale getSaleById(Long id) {
			return saleService.getSaleById(id);
		}

		// Save sale
		@PostMapping("/save")
		public Sale saveSale(@RequestBody Sale sale) {
			return saleService.saveSale(sale);
		}

		// Update sale by id
		@PutMapping("/update")
		public Sale updateSale(@RequestBody Sale sale) {
			return saleService.updateSale(sale);
		}

		// Delete sale by id
		@DeleteMapping("/delete/{id}")
		public void deleteSale(@PathVariable Long id) {
			saleService.deleteSale(id);
		}
}
