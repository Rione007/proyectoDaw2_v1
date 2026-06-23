package cibertec.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cibertec.pe.DTO.OrdenCompraDTO;
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
	public OrdenCompra buscar(@PathVariable Long id) {

		return service.buscarPorId(id);
	}

	@PostMapping
	public OrdenCompra guardar(@RequestBody OrdenCompraDTO dto) {

		return service.guardar(dto);
	}

	@PutMapping("/edit/{id}")
	public OrdenCompra actualizar(@PathVariable Long id, @RequestBody OrdenCompraDTO dto) {

		return service.actualizar(id, dto);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {

		service.eliminar(id);
	}

}