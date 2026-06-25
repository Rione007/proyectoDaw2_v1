package cibertec.pe.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cibertec.pe.DTO.ProductoDTO;

@FeignClient(name = "Rest-Inventario" ,  url = "http://localhost:9001")
public interface ProductoClient {
	

    @GetMapping("/productos/{id}")
    ProductoDTO buscarProducto(
            @PathVariable("id") Long id
    );

}
