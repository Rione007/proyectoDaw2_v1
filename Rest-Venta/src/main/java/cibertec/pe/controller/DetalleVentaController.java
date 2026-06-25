package cibertec.pe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cibertec.pe.entity.DetalleVenta;
import cibertec.pe.service.IDetalleVentaService;

@RestController	
@RequestMapping("/api/detalleVenta")
public class DetalleVentaController {


    @Autowired
    private IDetalleVentaService detalleVentaService;


    @GetMapping
    public List<DetalleVenta> findAll() {

        return detalleVentaService.findAll();

    }


    @GetMapping("/{id}")
    public DetalleVenta findById(
            @PathVariable long id) {

        return detalleVentaService.findById(id)
                .orElseThrow(() ->
                new RuntimeException("Detalle no encontrado"));

    }


    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable long id) {

        detalleVentaService.deleteById(id);

        return "Detalle eliminado correctamente";
    }

}