package cibertec.pe.service;

import java.util.List;

import cibertec.pe.entity.OrdenCompra;

public interface IOrdenCompraService {

	
	    List<OrdenCompra> listar();
	    OrdenCompra buscarPorId(Long id);
	    OrdenCompra guardar(OrdenCompra ordenCompra);
	    OrdenCompra actualizar(Long id, OrdenCompra ordenCompra);
	    void eliminar(Long id);

	
	
	
	
	
	
	
}
