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

import cibertec.pe.entity.DetalleCompra;
import cibertec.pe.service.IDetalleCompraService;

@RestController
@RequestMapping("/api/detalle_compra")
public class DetalleCompraController {
	
	
	  @Autowired
	  private IDetalleCompraService service;
	
	
	
	    @GetMapping
	    public List<DetalleCompra> listar() {
	        return service.listar();
	    }

	    @GetMapping("/buscar/{id}")
	    public DetalleCompra buscarPorId(@PathVariable Long id) {
	        return service.buscarPorId(id);
	    }

	    @PostMapping
	    public DetalleCompra guardar(@RequestBody DetalleCompra detalleCompra) {
	        return service.guardar(detalleCompra);
	    }

	    @PutMapping("/edit/{id}")
	    public DetalleCompra actualizar(@PathVariable Long id,@RequestBody DetalleCompra detalleCompra) {
	        return service.actualizar(id, detalleCompra);
	    }

	    @DeleteMapping("/{id}")
	    public void eliminar(@PathVariable Long id) {
	        service.eliminar(id);
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	

}
