package cibertec.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cibertec.pe.entites.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {

}
