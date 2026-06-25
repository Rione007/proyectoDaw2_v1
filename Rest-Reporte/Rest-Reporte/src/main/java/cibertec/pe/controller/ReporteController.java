package cibertec.pe.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cibertec.pe.DTO.ProductoMasVendidoDTO;
import cibertec.pe.DTO.ReporteCajaDTO;
import cibertec.pe.DTO.ReporteVentasDTO;
import cibertec.pe.DTO.VentaDTO;
import cibertec.pe.service.ReporteService;

@RestController
public class ReporteController {

	 @Autowired
	    private ReporteService reporteService;

	    @GetMapping("/reportes/ventas")
	    public List<VentaDTO> listarVentas() {
	        return reporteService.obtenerVentas();
	    }
	    
	    
	    
	    @GetMapping("/reportes/ventas-total")
	    public ReporteVentasDTO resumenVentas() {
	        return reporteService.obtenerResumenVentas();
	    }
	    
	    
	    
	    
	    
	    @GetMapping("/reportes/productos-mas-vendidos")
	    public List<ProductoMasVendidoDTO> productosMasVendidos() {

	        return reporteService.obtenerProductosMasVendidos();

	    }
	    
	    
	    
	    
	    
	    
	    @GetMapping("/reportes/ventas-rango")
	    public ReporteVentasDTO ventasPorRango(

	            @RequestParam
	            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	            LocalDateTime inicio,

	            @RequestParam
	            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	            LocalDateTime fin) {

	        return reporteService.obtenerVentasPorRango(inicio, fin);
	    }
	    
	    
	    
	    
	    @GetMapping("/reportes/ingresos-egresos")
	    public ReporteCajaDTO ingresosEgresos() {
	        return reporteService.obtenerIngresosEgresos();
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}
