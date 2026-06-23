package cibertec.pe.DTO;

public class ProductoMasVendidoDTO {

	
	
	   private long productoId;
	    private String descripcion;
	    private int cantidadVendida;
	    
	    
	    
	    public ProductoMasVendidoDTO () {}



		public ProductoMasVendidoDTO(long productoId, String descripcion, int cantidadVendida) {
			super();
			this.productoId = productoId;
			this.descripcion = descripcion;
			this.cantidadVendida = cantidadVendida;
		}

		
		
		
		


		public ProductoMasVendidoDTO(String descripcion, int cantidadVendida) {
			super();
			this.descripcion = descripcion;
			this.cantidadVendida = cantidadVendida;
		}



		public long getProductoId() {
			return productoId;
		}



		public void setProductoId(long productoId) {
			this.productoId = productoId;
		}



		public String getDescripcion() {
			return descripcion;
		}



		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}



		public int getCantidadVendida() {
			return cantidadVendida;
		}



		public void setCantidadVendida(int cantidadVendida) {
			this.cantidadVendida = cantidadVendida;
		}
	    
	    
	    
	    
	    
}
