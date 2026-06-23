package cibertec.pe.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cibertec.pe.DTO.DetalleVentaDTO;
import cibertec.pe.DTO.MovimientoCajaDTO;
import cibertec.pe.DTO.VentaDTO;

@FeignClient (name = "Rest-Venta") 
public interface DetalleVentaClient {

	
	
	   @GetMapping("/detalleVenta")
	    List<DetalleVentaDTO> listarDetalles();
	
		
	   @GetMapping("/ventas")
	   List<VentaDTO> listarventas();
	   
	   
	   
	   

	   	
	
}
