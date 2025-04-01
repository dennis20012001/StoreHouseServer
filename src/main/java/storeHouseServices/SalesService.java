package storeHouseServices;

import java.util.List;

import org.springframework.stereotype.Service;

import storeHouse.Objects.Sales;
import storeHouseRepositories.SalesRepository;

@Service
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
