package cibertec.pe.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cibertec.pe.entity.CommentsDto;
import cibertec.pe.entity.PostDto;


@FeignClient(name = "POST-CLIENT", url = "https://jsonplaceholder.typicode.com")
public interface PostFeignClient {
	
	@GetMapping("/posts")
	public List<PostDto> getPost();
	
	
	@GetMapping("/comments")
	public List<CommentsDto> getComments();

}
