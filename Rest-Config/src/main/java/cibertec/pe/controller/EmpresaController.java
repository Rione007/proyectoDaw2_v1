package cibertec.pe.controller;

import java.util.List;
import java.util.stream.Collectors;

import cibertec.pe.dto.EmpresaDTO;
import cibertec.pe.entities.Empresa;
import cibertec.pe.service.interfaces.IEmpresaService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private IEmpresaService empresaService;
    
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/listar")
    public ResponseEntity<List<EmpresaDTO>> listarEmpresas() {
        List<Empresa> empresas = empresaService.getEmpresa();
        
        List<EmpresaDTO> dtos = empresas.stream()
                .map(empresa -> modelMapper.map(empresa, EmpresaDTO.class))
                .collect(Collectors.toList());
                
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<EmpresaDTO> obtenerEmpresaPorId(@PathVariable("id") Long id) {
        return empresaService.getEmpresaId(id)
                .map(empresa -> new ResponseEntity<>(modelMapper.map(empresa, EmpresaDTO.class), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/crear")
    public ResponseEntity<EmpresaDTO> crearEmpresa(@RequestBody EmpresaDTO empresaDTO) {
        Empresa empresa = modelMapper.map(empresaDTO, Empresa.class);
        empresa.setId(null);
        Empresa nuevaEmpresa = empresaService.createEmpresa(empresa);
        
        return new ResponseEntity<>(modelMapper.map(nuevaEmpresa, EmpresaDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<EmpresaDTO> actualizarEmpresa(@PathVariable("id") int id, @RequestBody EmpresaDTO empresaDTO) {
        try {
            Empresa empresa = modelMapper.map(empresaDTO, Empresa.class);
            Empresa empresaActualizada = empresaService.updateEmpresa(id, empresa);
            return new ResponseEntity<>(modelMapper.map(empresaActualizada, EmpresaDTO.class), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarEmpresa(@PathVariable("id") int id) {
        try {
            empresaService.deleteEmpresa(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}