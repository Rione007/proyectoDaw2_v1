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

import cibertec.pe.DTO.CierreCajaDTO;

import cibertec.pe.service.ICierreCajaService;

@RestController
@RequestMapping("/cierreCaja")
public class ICierreCajaController {

	@Autowired
	private ICierreCajaService cierrecajaservcie;



	    @GetMapping("/list")
	    public List<CierreCajaDTO> listar() {
	        return cierrecajaservcie.findAll();
	    }


	    @GetMapping("/buscar/{codigo}")
	    public Optional<CierreCajaDTO> buscarId(@PathVariable long codigo) {
	        return cierrecajaservcie.findById(codigo);
	    }


	    @PostMapping("/save")
	    public CierreCajaDTO guardar(@RequestBody CierreCajaDTO dto) {
	        return cierrecajaservcie.save(dto);
	    }

	
	    @PutMapping("/{id}")
	    public CierreCajaDTO actualizar(@PathVariable long id,
	                                    @RequestBody CierreCajaDTO dto) {
	        return cierrecajaservcie.update(id, dto);
	    }


	    @DeleteMapping("/{id}")
	    public void eliminar(@PathVariable long id) {
	        cierrecajaservcie.deleteById(id);
	    }
	}