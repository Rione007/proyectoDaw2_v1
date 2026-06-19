package cibertec.pe.service;

import java.util.List;

import cibertec.pe.entity.Proveedor;

public interface IProveedorService {
	
	

    List<Proveedor> listar();
    Proveedor buscarPorId(Long id);
    Proveedor guardar(Proveedor proveedor);
    Proveedor actualizar(Long id, Proveedor proveedor);
    void eliminar(Long id);
	
	
	
	
	
	
	
	
	
	
	

}
