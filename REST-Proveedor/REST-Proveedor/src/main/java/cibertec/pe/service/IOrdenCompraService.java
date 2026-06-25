package cibertec.pe.service;

import java.util.List;

import cibertec.pe.DTO.OrdenCompraDTO;
import cibertec.pe.entity.OrdenCompra;

public interface IOrdenCompraService {



	    List<OrdenCompra> listar();

	    OrdenCompra buscarPorId(Long id);

	    OrdenCompra guardar(OrdenCompraDTO dto);

	    OrdenCompra actualizar(Long id, OrdenCompraDTO dto);

	    void eliminar(Long id);
	}
    
