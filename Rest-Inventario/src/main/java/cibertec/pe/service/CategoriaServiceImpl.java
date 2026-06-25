package cibertec.pe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.entites.Categoria;
import cibertec.pe.repository.ICategoriaRepository;


@Service
public class CategoriaServiceImpl implements ICategoriaService {


    @Autowired
    private ICategoriaRepository repo;



    @Override
    public List<Categoria> findAll() {

        return repo.findAll();

    }



    @Override
    public Optional<Categoria> findById(Long id) {

        return repo.findById(id);

    }



    @Override
    public Categoria save(Categoria categoria) {

        return repo.save(categoria);

    }



    @Override
    public Categoria update(Long id, Categoria categoria) {


        Categoria categoriaExistente = repo.findById(id)
                .orElseThrow(() -> 
                    new RuntimeException("Categoria no encontrada"));


        categoriaExistente.setNombre(
                categoria.getNombre()
        );


        categoriaExistente.setEstado(
                categoria.getEstado()
        );


        return repo.save(categoriaExistente);

    }



    @Override
    public void delete(Long id) {


        Categoria categoria = repo.findById(id)
                .orElseThrow(() -> 
                    new RuntimeException("Categoria no encontrada"));


        repo.delete(categoria);

    }


}