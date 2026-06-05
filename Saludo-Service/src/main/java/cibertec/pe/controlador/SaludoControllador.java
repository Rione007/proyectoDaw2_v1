package cibertec.pe.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cibertec.pe.entity.CommentsDto;
import cibertec.pe.entity.PostDto;
import cibertec.pe.feignclients.PostFeignClient;

@RestController
@RequestMapping("/api/saludo")
public class SaludoControllador {

	@Autowired
	private PostFeignClient postfclient;

	
	@GetMapping("/saludar")
	public String saludoCibertec() {
		return "Hola manin";
	}
	
	
	@GetMapping("/findAllPosts")
	public List<PostDto> listarPost(){
		return postfclient.getPost();
	}
	
	@GetMapping("/findAllComments")
	public List<CommentsDto> listarComments(){
		return postfclient.getComments();
	}
}
