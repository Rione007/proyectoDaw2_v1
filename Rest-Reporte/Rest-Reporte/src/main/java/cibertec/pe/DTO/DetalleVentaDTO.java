package cibertec.pe.DTO;

public class DetalleVentaDTO {

	 private Long idDetalleVenta;
	    private long productoId;
	    private String descripcion;
	    private int cantidad;
	    private double precioUnitario;
	    private double subTotal;
	    
	    
	    public DetalleVentaDTO () {}


		public Long getIdDetalleVenta() {
			return idDetalleVenta;
		}


		public void setIdDetalleVenta(Long idDetalleVenta) {
			this.idDetalleVenta = idDetalleVenta;
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


		public int getCantidad() {
			return cantidad;
		}


		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}


		public double getPrecioUnitario() {
			return precioUnitario;
		}


		public void setPrecioUnitario(double precioUnitario) {
			this.precioUnitario = precioUnitario;
		}


		public double getSubTotal() {
			return subTotal;
		}


		public void setSubTotal(double subTotal) {
			this.subTotal = subTotal;
		}
	    
	    
	    
	    
	
	
	
}
