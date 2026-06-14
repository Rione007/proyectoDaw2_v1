package cibertec.pe.DTO;

public class DetalleVentaDTO {

	
	 	private Long productoId;   // viene de INVENTARIO (referencia)
	    private Integer cantidad;
		public Long getProductoId() {
			return productoId;
		}
		public void setProductoId(Long productoId) {
			this.productoId = productoId;
		}
		public Integer getCantidad() {
			return cantidad;
		}
		public void setCantidad(Integer cantidad) {
			this.cantidad = cantidad;
		}
	
	
	    
	    
	    
	    
	    
}
