package cibertec.pe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.entity.Cliente;
import cibertec.pe.repository.IClienteRepository;

@Service
public class IClienteServiceImpl implements IClienteService {
	
	
	@Autowired
	private IClienteRepository clienterepo;

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return clienterepo.findAll();
	}

	@Override
	public Optional<Cliente> findById(long codigo) {
		// TODO Auto-generated method stub
		return clienterepo.findById(codigo);
	}

	@Override
	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienterepo.save(cliente);
	}

	@Override
	public String update(long codigo, Cliente cliente) {
	
		Cliente cli = clienterepo.findById(codigo).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

		cli.setNombre(cliente.getNombre());
		cli.setApellido(cliente.getApellido());
		cli.setDocumento(cliente.getDocumento());
		cli.setEmail(cliente.getEmail());
		cli.setTelefono(cliente.getTelefono());
		clienterepo.save(cli);
		return "Cliente Editado Correctamente";
	}
	
	
	
	
	
	
	
	
	

	@Override
	public void deleteById(long codigo) {
		clienterepo.deleteById(codigo);
		
	}
	
	
	
	
	
	
	
	

}
