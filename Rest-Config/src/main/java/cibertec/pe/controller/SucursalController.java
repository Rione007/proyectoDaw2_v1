package cibertec.pe.controller;

import java.util.List;
import java.util.stream.Collectors;

import cibertec.pe.dto.SucursalDTO;
import cibertec.pe.entities.Sucursal;
import cibertec.pe.service.interfaces.ISucursalService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

    @Autowired
    private ISucursalService sucursalService;
    
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/listar")
    public ResponseEntity<List<SucursalDTO>> listarSucursales() {
        List<Sucursal> sucursales = sucursalService.getSucursal();
        
        List<SucursalDTO> dtos = sucursales.stream()
                .map(sucursal -> modelMapper.map(sucursal, SucursalDTO.class))
                .collect(Collectors.toList());
                
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<SucursalDTO> obtenerSucursalPorId(@PathVariable("id") Long id) {
        return sucursalService.getSucursalId(id)
                .map(sucursal -> new ResponseEntity<>(modelMapper.map(sucursal, SucursalDTO.class), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/crear")
    public ResponseEntity<SucursalDTO> crearSucursal(@RequestBody SucursalDTO sucursalDTO) {
        Sucursal sucursal = modelMapper.map(sucursalDTO, Sucursal.class);
        sucursal.setId(null);
        Sucursal nuevaSucursal = sucursalService.createSucursal(sucursal);
        return new ResponseEntity<>(modelMapper.map(nuevaSucursal, SucursalDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<SucursalDTO> actualizarSucursal(@PathVariable("id") int id, @RequestBody SucursalDTO sucursalDTO) {
        try {
            Sucursal sucursal = modelMapper.map(sucursalDTO, Sucursal.class);
            Sucursal sucursalActualizada = sucursalService.updateSucursal(id, sucursal);
            return new ResponseEntity<>(modelMapper.map(sucursalActualizada, SucursalDTO.class), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarSucursal(@PathVariable("id") int id) {
        try {
            sucursalService.deleteSucursal(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}