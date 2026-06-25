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

import cibertec.pe.DTO.CajaDTO;
import cibertec.pe.entity.Caja;
import cibertec.pe.service.ICajaService;

@RestController
@RequestMapping("/api/caja")
public class CajaController {

	@Autowired
	private ICajaService cajaService;

    @GetMapping("/list")
    public List<CajaDTO> listar() {
        return cajaService.findAll();
    }

    @GetMapping("/buscar/{codigo}")
    public Optional<CajaDTO> buscarId(@PathVariable long codigo) {
        return cajaService.findById(codigo);
    }

    @PostMapping("/save")
    public CajaDTO guardar(@RequestBody CajaDTO dto) {
        return cajaService.save(dto);
    }

    @PutMapping("/{id}")
    public CajaDTO actualizar(@PathVariable Long id, @RequestBody CajaDTO dto) {
        return cajaService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        cajaService.deleteById(id);
    }
}