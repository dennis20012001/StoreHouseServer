package storeHouseServices;

import java.util.List;

import storeHouse.Objects.Sales;
import storeHouse.Objects.Users;
import storeHouseRepositories.SalesRepository;
import storeHouseRepositories.UserRepository;

public class SalesService {
	private final SalesRepository SalesRepository;

    public SalesService(SalesRepository SalesRepository) {
        this.SalesRepository = SalesRepository;
    }

    public List<Sales> listarUsuarios() {
        return SalesRepository.findAll();
    }

    public Sales guardarUsuario(Sales sales) {
        return SalesRepository.save(sales);
    }

    public void eliminarUsuario(Long id) {
    	SalesRepository.deleteById(id);
    }
}
