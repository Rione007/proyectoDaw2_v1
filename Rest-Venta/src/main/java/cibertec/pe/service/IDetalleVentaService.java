package cibertec.pe.service;

import java.util.List;
import java.util.Optional;

import cibertec.pe.entity.DetalleVenta;

public interface IDetalleVentaService {
	
	
	List<DetalleVenta>			findAll();
	Optional<DetalleVenta>      findById(long codigo);
	public DetalleVenta 		save(DetalleVenta detalleVenta);
	DetalleVenta			update(long codigo, DetalleVenta detalleVenta);
	void 				        deleteById(long codigo);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
