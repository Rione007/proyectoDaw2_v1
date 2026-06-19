package cibertec.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cibertec.pe.entity.OrdenCompra;
import cibertec.pe.service.IOrdenCompraService;

@RestController
@RequestMapping("/orden_compra")
public class OrdenCompraController {

	
	
	   	@Autowired
	    private IOrdenCompraService service;
	
	    @GetMapping
	    public List<OrdenCompra> listar() {
	        return service.listar();
	    }

	    @GetMapping("/buscar/{id}")
	    public OrdenCompra buscarPorId(@PathVariable Long id) {
	        return service.buscarPorId(id);
	    }

	    @PostMapping
	    public OrdenCompra guardar(@RequestBody OrdenCompra ordenCompra) {
	        return service.guardar(ordenCompra);
	    }

	    @PutMapping("/edit/{id}")
	    public OrdenCompra actualizar( @PathVariable Long id,@RequestBody OrdenCompra ordenCompra){
	        return service.actualizar(id, ordenCompra);
	    }

	    @DeleteMapping("/{id}")
	    public void eliminar(@PathVariable Long id) {
	        service.eliminar(id);
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
