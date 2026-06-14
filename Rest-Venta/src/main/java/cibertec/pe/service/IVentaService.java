package cibertec.pe.service;

import java.util.List;
import java.util.Optional;

import cibertec.pe.DTO.VentaDTO;
import cibertec.pe.entity.Venta;

public interface IVentaService {
	
	
	List<Venta>				findAll();
	Optional<Venta>         findById(long codigo);
	public Venta 			save(Venta venta);
	Venta					update(long codigo, Venta venta);
	public void 			deleteById(long codigo);
	Venta 					crearVenta(VentaDTO dto);
	
	
	
	
	
	
	
	
	
	
	
	
	

}
