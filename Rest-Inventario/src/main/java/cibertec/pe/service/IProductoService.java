package cibertec.pe.service;

import java.util.List;
import java.util.Optional;

import cibertec.pe.DTO.ProductoDTO;
import cibertec.pe.entites.Producto;

public interface IProductoService {

	 List<Producto> findAll();

	    Optional<Producto> findById(Long id);

	    Producto save(ProductoDTO dto);

	    Producto update(Long id, ProductoDTO dto);

	    void deleteById(Long id);
}