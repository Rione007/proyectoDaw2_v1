package cibertec.pe.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cibertec.pe.DTO.StockDTO;
import cibertec.pe.service.IStockService;



@RestController
@RequestMapping("/api/stocks")
public class StockController {



    @Autowired
    private IStockService service;



    @GetMapping
    public List<StockDTO> listar(){

        return service.findAll();

    }



    @GetMapping("/{id}")
    public StockDTO buscar(
            @PathVariable Long id){

        return service.findById(id)
                .orElseThrow();

    }



    @PostMapping
    public StockDTO guardar(
            @RequestBody StockDTO dto){

        return service.save(dto);

    }



    @PutMapping("/{id}")
    public StockDTO actualizar(
            @PathVariable Long id,
            @RequestBody StockDTO dto){

        return service.update(id, dto);

    }



    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Long id){

        service.delete(id);

    }


}