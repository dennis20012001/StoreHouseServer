package storeHouseServices;

import java.util.List;

import storeHouse.Objects.DetailSale;
import storeHouse.Objects.Users;
import storeHouseRepositories.DetailSaleRepository;
import storeHouseRepositories.SalesRepository;
import storeHouseRepositories.UserRepository;

public class DetailSaleService {
	private final DetailSaleRepository detailSaleRepository;

    public DetailSaleService(DetailSaleRepository detailSaleRepository) {
        this.detailSaleRepository = detailSaleRepository;
    }

    public List<DetailSale> listarUsuarios() {
        return detailSaleRepository.findAll();
    }

    public DetailSale guardarUsuario(DetailSale detailSale) {
        return detailSaleRepository.save(detailSale);
    }

    public void eliminarUsuario(Long id) {
    	detailSaleRepository.deleteById(id);
    }
}
