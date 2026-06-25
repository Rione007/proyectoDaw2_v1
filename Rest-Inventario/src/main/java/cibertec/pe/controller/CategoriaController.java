package cibertec.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cibertec.pe.entites.Categoria;
import cibertec.pe.service.ICategoriaService;


@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {


    @Autowired
    private ICategoriaService service;



    @GetMapping
    public List<Categoria> listar(){

        return service.findAll();

    }



    @GetMapping("/{id}")
    public Categoria buscar(
            @PathVariable Long id){

        return service.findById(id)
                .orElseThrow();

    }



    @PostMapping
    public Categoria guardar(
            @RequestBody Categoria categoria){

        return service.save(categoria);

    }



    @PutMapping("/{id}")
    public Categoria actualizar(
            @PathVariable Long id,
            @RequestBody Categoria categoria){

        return service.update(id, categoria);

    }



    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Long id){

        service.delete(id);

    }

}