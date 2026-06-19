package cibertec.pe.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cibertec.pe.DTO.ProductoDTO;

@FeignClient(name = "Rest-Inventario", url = "http://localhost:9001/")
public interface ProductoFeignClient {

	
	//DEBO CAMBIAR POR EL QUE ESTA EN EL INVENTARIO DE PRODUCTO CONTROLLER
	@GetMapping("/productos/{id}")
	ProductoDTO obtenerProducto(@PathVariable("id") Long id);
	
	
	
}
