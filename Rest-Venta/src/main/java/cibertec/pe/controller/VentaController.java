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

import cibertec.pe.entity.Venta;
import cibertec.pe.service.IVentaService;

@RestController
@RequestMapping("/ventas")
public class VentaController {
	
	@Autowired
    private IVentaService ventaService;

 
    @GetMapping
    public List<Venta> findAll() {
        return ventaService.findAll();
    }


    @GetMapping("/{id}")
    public Optional<Venta> findById(@PathVariable long id) {
        return ventaService.findById(id);
    }


    @PostMapping("/save")
    public Venta save(@RequestBody Venta venta) {
        return ventaService.save(venta);
    }

 
    @PutMapping("/{id}")
    public Venta update(@PathVariable long id, @RequestBody Venta venta) {
        return ventaService.update(id, venta);
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        ventaService.deleteById(id);
        return "Venta eliminada correctamente";
    }
}