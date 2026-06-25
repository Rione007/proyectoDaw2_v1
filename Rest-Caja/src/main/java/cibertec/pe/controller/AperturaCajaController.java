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

import cibertec.pe.DTO.AperturaCajaDTO;

import cibertec.pe.service.IAperturaCajaService;

@RestController
@RequestMapping("/api/aperturaCaja")
public class AperturaCajaController {
	
	
	
	
	  @Autowired
	    private IAperturaCajaService aperturaservice;

	
	    @GetMapping("/list")
	    public List<AperturaCajaDTO> listar() {
	        return aperturaservice.findAll();
	    }


	    @GetMapping("/buscar/{codigo}")
	    public Optional<AperturaCajaDTO> buscarId(@PathVariable long codigo) {
	        return aperturaservice.findById(codigo);
	    }

	  
	    @PostMapping("/save")
	    public AperturaCajaDTO guardar(@RequestBody AperturaCajaDTO dto) {
	        return aperturaservice.save(dto);
	    }


	    @PutMapping("/{id}")
	    public AperturaCajaDTO actualizar(@PathVariable long id,
	                                      @RequestBody AperturaCajaDTO dto) {
	        return aperturaservice.update(id, dto);
	    }


	    @DeleteMapping("/{id}")
	    public void eliminar(@PathVariable long id) {
	        aperturaservice.deleteById(id);
	    }
	}
