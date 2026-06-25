package cibertec.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cibertec.pe.entites.Almacen;
import cibertec.pe.service.IAlmacenService;

@RestController
@RequestMapping("/almacenes")
public class AlmacenController {

	@Autowired
	private IAlmacenService service;

	@GetMapping
	public List<Almacen> listar() {

		return service.findAll();

	}

	@GetMapping("/{id}")
	public Almacen buscar(@PathVariable Long id) {

		return service.findById(id).orElseThrow();

	}

	@PostMapping
	public Almacen guardar(@RequestBody Almacen almacen) {

		return service.save(almacen);

	}

	@PutMapping("/{id}")
	public Almacen actualizar(@PathVariable Long id, @RequestBody Almacen almacen) {

		return service.update(id, almacen);

	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {

		service.delete(id);

	}

}