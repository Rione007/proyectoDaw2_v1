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

import cibertec.pe.entity.Proveedor;
import cibertec.pe.service.IProveedorService;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

	
	 @Autowired
	 private IProveedorService service;
	
	
	    @GetMapping
	    public List<Proveedor> listar() {
	        return service.listar();
	    }

	    @GetMapping("/buscar/{id}")
	    public Proveedor buscarPorId(@PathVariable Long id) {
	        return service.buscarPorId(id);
	    }

	    @PostMapping("/save")
	    public Proveedor guardar(@RequestBody Proveedor proveedor) {
	        return service.guardar(proveedor);
	    }

	    @PutMapping("/editar/{id}")
	    public Proveedor actualizar(@PathVariable Long id,@RequestBody Proveedor proveedor) {
	        return service.actualizar(id, proveedor);
	    }

	    @DeleteMapping("/{id}")
	    public void eliminar(@PathVariable Long id) {
	        service.eliminar(id);
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
}
