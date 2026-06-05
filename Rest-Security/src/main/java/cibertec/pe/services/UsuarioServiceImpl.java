package cibertec.pe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cibertec.pe.entities.Usuario;
import cibertec.pe.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImpl implements IAuthService {
	
	@Autowired
	private IUsuarioRepository repository;
	
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

	@Override
	public Usuario saveUser(Usuario user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return repository.save(user);
              
	}

	@Override
	public List<Usuario> listar() {
		return repository.findAll();
	}

	@Override
	public String generateToken(String username) {
		 return jwtService.generateToken(username);
	}

	@Override
	public void validateToken(String token) {
		 jwtService.validateToken(token);
		
	}

	public Usuario obtenerPorUsername(String username) {
	    return repository.findByUsername(username)
	            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
	}
}
