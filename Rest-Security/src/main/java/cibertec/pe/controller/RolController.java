package cibertec.pe.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cibertec.pe.dtos.RolDTO;
import cibertec.pe.entities.Rol;
import cibertec.pe.services.IRolService;

@RestController
@RequestMapping("/api/rol")
public class RolController {

    @Autowired
    private IRolService rolService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/listar")
    public ResponseEntity<List<RolDTO>> listarRoles() {

        List<Rol> roles = rolService.listar();

        List<RolDTO> dtos = roles.stream()
                .map(rol -> modelMapper.map(rol, RolDTO.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<RolDTO> obtenerRol(@PathVariable Long id) {

        Rol rol = rolService.buscarPorId(id);

        if (rol == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                modelMapper.map(rol, RolDTO.class),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<RolDTO> crearRol(
            @RequestBody RolDTO dto) {
    	dto.setId(null);

        Rol rol = modelMapper.map(dto, Rol.class);

        Rol nuevo = rolService.guardar(rol);

        return new ResponseEntity<>(
                modelMapper.map(nuevo, RolDTO.class),
                HttpStatus.CREATED);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<RolDTO> actualizarRol(
            @PathVariable Long id,
            @RequestBody RolDTO dto) {

        Rol rol = modelMapper.map(dto, Rol.class);

        Rol actualizado = rolService.actualizar(id, rol);

        if (actualizado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                modelMapper.map(actualizado, RolDTO.class),
                HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarRol(
            @PathVariable Long id) {

        rolService.eliminar(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}