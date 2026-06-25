package cibertec.pe.service;

import java.util.List;
import java.util.Optional;

import cibertec.pe.entites.Categoria;

public interface ICategoriaService {


    List<Categoria> findAll();


    Optional<Categoria> findById(Long id);


    Categoria save(Categoria categoria);


    Categoria update(Long id, Categoria categoria);


    void delete(Long id);

}