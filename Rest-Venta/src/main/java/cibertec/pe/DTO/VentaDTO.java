package cibertec.pe.DTO;

import java.util.List;

public class VentaDTO {
	
	
		private Long idCliente;  
	    private String estado;
	    private List<DetalleVentaDTO> detalles;
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		public Long getIdCliente() {
			return idCliente;
		}
		public void setIdCliente(Long idCliente) {
			this.idCliente = idCliente;
		}
		public String getEstado() {
			return estado;
		}
		public void setEstado(String estado) {
			this.estado = estado;
		}
		public List<DetalleVentaDTO> getDetalles() {
			return detalles;
		}
		public void setDetalles(List<DetalleVentaDTO> detalles) {
			this.detalles = detalles;
		}
	
	    
	    
	    
	    

}
