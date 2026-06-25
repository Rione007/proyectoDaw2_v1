package cibertec.pe.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cibertec.pe.DTO.DetalleVentaDTO;
import cibertec.pe.DTO.MovimientoCajaDTO;
import cibertec.pe.DTO.VentaDTO;

@FeignClient (name = "REST-VENTA") 
public interface DetalleVentaClient {

	
	
	   @GetMapping("/api/detalleVenta")
	    List<DetalleVentaDTO> listarDetalles();
	
		
	   @GetMapping("/api/ventas")
	   List<VentaDTO> listarventas();
	   
	   	
	   
	   

	   	
	
}
