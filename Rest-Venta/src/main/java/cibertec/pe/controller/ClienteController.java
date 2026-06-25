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

import cibertec.pe.entity.Cliente;
import cibertec.pe.service.IClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	

    @Autowired
    private IClienteService clienteService;

    @GetMapping
    public List<Cliente> findAll() {
        return clienteService.findAll();
    }

 
    @GetMapping("/{id}")
    public Optional<Cliente> findById(@PathVariable long id) {
        return clienteService.findById(id);
    }

    @PostMapping("/saveCliente")
    public Cliente save(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

 
    @PutMapping("/{id}")
    public String update(@PathVariable long id, @RequestBody Cliente cliente) {
        return clienteService.update(id, cliente);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        clienteService.deleteById(id);
        return "Cliente eliminado correctamente";
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
