package cibertec.pe.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cibertec.pe.dtos.AuthRequest;
import cibertec.pe.dtos.LoginResponseDTO;
import cibertec.pe.dtos.UsuarioRequestDTO;
import cibertec.pe.dtos.UsuarioResponseDTO;
import cibertec.pe.entities.Rol;
import cibertec.pe.entities.Usuario;
import cibertec.pe.services.UsuarioServiceImpl;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    
    @PostMapping("/crear")
    public ResponseEntity<UsuarioResponseDTO> crearUsuario(
            @RequestBody UsuarioRequestDTO dto) {

        Usuario usuario = new Usuario();

        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());
        usuario.setNombres(dto.getNombres());
        usuario.setApellidos(dto.getApellidos());
        usuario.setEmail(dto.getEmail());
        usuario.setTelefono(dto.getTelefono());
        usuario.setSucursalId(dto.getSucursalId());
        usuario.setEstado(dto.getEstado());
        
        Rol rol = new Rol();
        rol.setId(dto.getRolId());

        usuario.setRol(rol);

        Usuario nuevo = usuarioService.saveUser(usuario);

        return new ResponseEntity<>(
                modelMapper.map(nuevo, UsuarioResponseDTO.class),
                HttpStatus.CREATED);
    }
    
    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios() {

        List<UsuarioResponseDTO> usuarios =
                usuarioService.listar()
                        .stream()
                        .map(usuario ->
                                modelMapper.map(
                                        usuario,
                                        UsuarioResponseDTO.class))
                        .collect(Collectors.toList());

        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
    
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @RequestBody AuthRequest authRequest) {

        Authentication authenticate =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                authRequest.getUsername(),
                                authRequest.getPassword()));

        if (!authenticate.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Usuario usuario =
                usuarioService.obtenerPorUsername(
                        authRequest.getUsername());

        String token =
                usuarioService.generateToken(
                        authRequest.getUsername());

        LoginResponseDTO response = new LoginResponseDTO();

        response.setToken(token);
        response.setUsuarioId(usuario.getId());
        response.setUsername(usuario.getUsername());
        response.setNombres(usuario.getNombres());
        response.setApellidos(usuario.getApellidos());
        response.setEmail(usuario.getEmail());
        response.setRolId(usuario.getRol().getId());
        response.setSucursalId(usuario.getSucursalId());


        return ResponseEntity.ok(response);
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
    	usuarioService.validateToken(token);
        return "Token is valid";
    }

}
