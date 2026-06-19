package cibertec.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.entity.Proveedor;
import cibertec.pe.repository.IProveedorRepository;

@Service
public class IProveedorServiceImpl implements IProveedorService {
	
	
	
    @Autowired
    private IProveedorRepository repository;

	@Override
	public List<Proveedor> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Proveedor buscarPorId(Long id) {
		// TODO Auto-generated method stub
		  return repository.findById(id).orElse(null);
	}

	@Override
	public Proveedor guardar(Proveedor proveedor) {
		// TODO Auto-generated method stub
        return repository.save(proveedor);
	}

	@Override
    public Proveedor actualizar(Long id,Proveedor proveedor){

        Proveedor p = repository.findById(id).orElse(null);


        if(p != null){

            p.setRazonSocial(proveedor.getRazonSocial());
            p.setRuc(proveedor.getRuc());
            p.setDireccion(proveedor.getDireccion());
            p.setEmail(proveedor.getEmail());
            p.setTelefono(proveedor.getTelefono());
            p.setEstado(proveedor.getEstado());
            return repository.save(p);
        } return null ;
    }
	
	

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		 repository.deleteById(id);
	}
	
	
	
	
	
	

}
