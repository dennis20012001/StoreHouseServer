package storeHouseServices;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import storeHouse.Objects.DetailSale;
import storeHouseRepositories.DetailSaleRepository;

@Service
public class DetailSaleService {
	private final DetailSaleRepository detailSaleRepository;

    public DetailSaleService(DetailSaleRepository detailSaleRepository) {
        this.detailSaleRepository = detailSaleRepository;
    }

	public List<DetailSale> getAllDetailSales() {
		return detailSaleRepository.findAll();
	}

	public DetailSale getDetailSaleById(Long id) {
		return detailSaleRepository.findById(id).orElse(null);
	}

	public DetailSale saveDetailSale(DetailSale detailSale) {
		return detailSaleRepository.save(detailSale);
	}

	public DetailSale updateDetailSale(DetailSale detailSale) {
		if (!detailSaleRepository.existsById(detailSale.getDetailId())) {
	        throw new EntityNotFoundException("DetailSale con ID " + detailSale.getDetailId() + " no encontrado.");
	    }
	    return detailSaleRepository.save(detailSale);
	}

	public void deleteDetailSale(Long id) {
		detailSaleRepository.deleteById(id);
	}

   
}
