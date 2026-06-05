package cibertec.pe.services;

import java.util.List;

import cibertec.pe.entities.Usuario;

public interface IAuthService {

	public Usuario saveUser(Usuario user);
	public List<Usuario> listar();
	
	public String generateToken(String username);
	
	public void validateToken(String token);
	public Usuario obtenerPorUsername(String username);
}
