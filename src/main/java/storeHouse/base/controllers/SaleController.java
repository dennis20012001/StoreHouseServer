/**
 * 
 */
/*package com.example.ProyectoPracticas.base.controllers;
 * package storeHouse.base.controllers;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.ProyectoPracticas.base.DTOs.SaleDTO;
import com.example.ProyectoPracticas.base.entities.Product;
import com.example.ProyectoPracticas.base.entities.Sale;
import com.example.ProyectoPracticas.base.services.ProductService;
import com.example.ProyectoPracticas.base.services.SaleService;
import com.example.ProyectoPracticas.base.services.UserService;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SaleService saleService;
    private final UserService userService;
    private final ProductService productService;

    public SaleController(SaleService saleService, UserService userService, ProductService productService) {
        this.saleService = saleService;
        this.userService = userService;
        this.productService = productService;
    }

    // Endpoint de prueba
    @PostMapping("/testSale")
    public void printTestSale() {
        System.out.println("El EndPoint responde.");
    }

    // Obtener lista de sales
    @GetMapping("/getAll")
    public List<Sale> getAllSales() {
        return saleService.getAllSales();
    }

    // Obtener sale por ID
    @GetMapping("/getById/{id}")
    public Sale getSaleById(@PathVariable Long id) {
        return saleService.getSaleById(id);
    }

    // Crear una nueva sale
    @PostMapping("/new")
    public ResponseEntity<?> addSale(@RequestBody SaleDTO saleDTO) {
        try {
            // Convertir el SaleDTO a Sale
            Sale sale = new Sale();

            sale.setDate(saleDTO.getDate());
            sale.setTotal(saleDTO.getTotal());

            User user = userService.getUserById(saleDTO.getUserId());
            if (user != null) {
                sale.setUserId(user);
            } else {
                return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
            }

            // Obtener el producto por el ID del DTO
            Product product = productService.getProductById(saleDTO.getProductId());
            if (product != null) {
                sale.setProductId(product); // Asignar el objeto Product
            } else {
                return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
            }

            // Guardar la sale
            Sale savedSale = saleService.saveSale(sale);

            // Retornar la respuesta con la sale guardada
            return new ResponseEntity<>(savedSale, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error interno del servidor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar una sale existente
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateSale(@PathVariable Long id, @RequestBody SaleDTO saleDTO) {
        Sale existingSale = saleService.getSaleById(id);
        if (existingSale != null) {
            existingSale.setDate(saleDTO.getDate());
            existingSale.setTotal(saleDTO.getTotal());

            // Obtener el usuario por el ID del DTO
            User user = userService.getUserById(saleDTO.getUserId());
            if (user != null) {
                existingSale.setUserId(user); // Asignar el objeto User
            } else {
                return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
            }

            // Obtener el producto por el ID del DTO
            Product product = productService.getProductById(saleDTO.getProductId());
            if (product != null) {
                existingSale.setProductId(product); // Asignar el objeto Product
            } else {
                return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
            }

            Sale updatedSale = saleService.saveSale(existingSale);
            return new ResponseEntity<>(updatedSale, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Venta no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una sale por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSale(@PathVariable("id") Long id) {
        Sale existingSale = saleService.getSaleById(id);
        if (existingSale != null) {
            saleService.deleteSale(id);
            return new ResponseEntity<>("Venta eliminada correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Venta no encontrada", HttpStatus.NOT_FOUND);
        }
    }
}
*/


