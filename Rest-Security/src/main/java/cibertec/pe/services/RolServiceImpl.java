package cibertec.pe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.entities.Rol;
import cibertec.pe.repository.IRolRepository;

@Service
public class RolServiceImpl implements IRolService {

	@Autowired
	private IRolRepository repository;

	@Override
	public List<Rol> listar() {
		return repository.findAll();
	}

	@Override
	public Rol buscarPorId(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Rol guardar(Rol rol) {
		return repository.save(rol);
	}

	@Override
	public Rol actualizar(Long id, Rol rol) {

		Rol rolBD = repository.findById(id).orElse(null);

		if (rolBD == null) {
			return null;
		}

		rolBD.setNombre(rol.getNombre());
		rolBD.setDescripcion(rol.getDescripcion());
		rolBD.setEstado(rol.getEstado());

		return repository.save(rolBD);
	}

	@Override
	public void eliminar(Long id) {
		repository.deleteById(id);
	}
}