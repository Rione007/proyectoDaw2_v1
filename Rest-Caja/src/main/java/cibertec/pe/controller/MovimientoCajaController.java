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

import cibertec.pe.DTO.MovimientoCajaDTO;
import cibertec.pe.entity.MovimientoCaja;
import cibertec.pe.service.IMovimientoCajaService;

@RestController
@RequestMapping("/api/movimientoCaja")
public class MovimientoCajaController {

	@Autowired
	private IMovimientoCajaService movimientocajaservice;

	@GetMapping("/list")
	public List<MovimientoCajaDTO> listar() {
		return movimientocajaservice.findAll();
	}

	@GetMapping("/buscar/{codigo}")
	public Optional<MovimientoCajaDTO> buscarId(@PathVariable long codigo) {
		return movimientocajaservice.findById(codigo);
	}

	@PostMapping("/save")
	public MovimientoCajaDTO guardar(@RequestBody MovimientoCajaDTO dto) {
		return movimientocajaservice.save(dto);
	}

	@PutMapping("/{id}")
	public MovimientoCajaDTO actualizar(@PathVariable long id, @RequestBody MovimientoCajaDTO dto) {
		return movimientocajaservice.update(id, dto);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable long id) {
		movimientocajaservice.deleteById(id);
	}
}