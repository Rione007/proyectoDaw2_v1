package cibertec.pe.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class VentaResponseDTO {

	
	   	private Long idVenta;
	    private LocalDateTime fecha;
	    private String estado;
	    private String clienteNombre;
	    private Double total;
	    private List<DetalleVentaResponseDTO> detalles;
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

		public Long getIdVenta() {
			return idVenta;
		}

		public void setIdVenta(Long idVenta) {
			this.idVenta = idVenta;
		}

		public LocalDateTime getFecha() {
			return fecha;
		}

		public void setFecha(LocalDateTime fecha) {
			this.fecha = fecha;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

		public String getClienteNombre() {
			return clienteNombre;
		}

		public void setClienteNombre(String clienteNombre) {
			this.clienteNombre = clienteNombre;
		}

		public Double getTotal() {
			return total;
		}

		public void setTotal(Double total) {
			this.total = total;
		}

		public List<DetalleVentaResponseDTO> getDetalles() {
			return detalles;
		}

		public void setDetalles(List<DetalleVentaResponseDTO> detalles) {
			this.detalles = detalles;
		}
	    
	    
	    
	    
	    
	    
	    
	    
	 
}
