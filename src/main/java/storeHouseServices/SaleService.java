package storeHouseServices;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import storeHouse.Objects.Sale;
import storeHouseRepositories.SaleRepository;

@Service
public class SaleService {
	private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }
    
    public List<Sale> getAllSales() {
		return saleRepository.findAll();
	}

	public Sale getSaleById(Long id) {
		return saleRepository.findById(id).orElse(null);
	}

	public Sale saveSale(Sale sale) {
		return saleRepository.save(sale);
	}
	
	public Sale updateSale(Sale sale) {
	    if (!saleRepository.existsById(sale.getSaleId())) {
	        throw new EntityNotFoundException("Sale con ID " + sale.getSaleId() + " no encontrado.");
	    }
	    return saleRepository.save(sale);
	}
	
	public void deleteSale(Long id) {
		saleRepository.deleteById(id);;
	}
}
