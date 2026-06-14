package cibertec.pe.service;

import java.util.List;
import java.util.Optional;

import cibertec.pe.entity.Cliente;

public interface IClienteService {
	
	
	
	List<Cliente>     		findAll();
	Optional<Cliente>       findById(long codigo);
	public Cliente 			save(Cliente cliente);
	public String 			update(long codigo, Cliente cliente);
	public void 			deleteById(long codigo);
	
	
	
	
	
	
	
	

}
