package cibertec.pe.services;

import java.util.List;

import cibertec.pe.entities.Rol;

public interface IRolService {
	
	List<Rol> listar();

	Rol buscarPorId(Long id);

	Rol guardar(Rol rol);

	Rol actualizar(Long id, Rol rol);

	void eliminar(Long id);
}
