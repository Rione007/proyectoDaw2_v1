package cibertec.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.entity.OrdenCompra;
import cibertec.pe.repository.IOrdenCompraRepository;

@Service
public class IOrdenCompraServiceImpl implements IOrdenCompraService {
	
	
    @Autowired
    private IOrdenCompraRepository repository;

	@Override
	public List<OrdenCompra> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public OrdenCompra buscarPorId(Long id) {
		// TODO Auto-generated method stub
		 return repository.findById(id).orElse(null);
	}

	@Override
	public OrdenCompra guardar(OrdenCompra ordenCompra) {
		// TODO Auto-generated method stub
		  return repository.save(ordenCompra);
	}
	   @Override
	    public OrdenCompra actualizar(Long id, OrdenCompra ordenCompra) {

	        OrdenCompra oc = repository.findById(id).orElse(null);

	        if (oc != null) {

	            oc.setProveedor(ordenCompra.getProveedor());
	            oc.setFecha(ordenCompra.getFecha());
	            oc.setTotal(ordenCompra.getTotal());
	            oc.setEstado(ordenCompra.getEstado());

	            return repository.save(oc);
	        }

	        return null;
	    }

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
	    repository.deleteById(id);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
