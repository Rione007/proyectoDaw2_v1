package cibertec.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cibertec.pe.DTO.VentaDTO;
import cibertec.pe.entity.Venta;
import cibertec.pe.service.IVentaService;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

	@Autowired
	private IVentaService service;

	@GetMapping
	public List<Venta> listar() {

		return service.findAll();

	}

	@GetMapping("/{id}")
	public Venta buscar(@PathVariable long id) {

		return service.findById(id).orElseThrow();

	}

	@PostMapping
	public Venta crear(@RequestBody VentaDTO dto) {

		return service.crearVenta(dto);

	}

	@PutMapping("/{id}")
	public Venta actualizar(@PathVariable long id, @RequestBody Venta venta) {

		return service.update(id, venta);

	}

	@DeleteMapping("/{id}")
	public String eliminar(@PathVariable long id) {

		service.deleteById(id);

		return "Venta eliminada";

	}

}