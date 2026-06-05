package cibertec.pe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cibertec.pe.entities.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByUsername(String username);

	Optional<Usuario> findByEmail(String email);
	
}
