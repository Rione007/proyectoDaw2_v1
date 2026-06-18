package cibertec.pe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DetalleVenta {

	
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idDetalleVenta;
	   	private long productoId; 		//cambiar por el que esta en clase de producto
	   	private String descripcion;
	   	private int  cantidad;
	   	private double precioUnitario;
	   	private double subTotal;
	
	   	public DetalleVenta () {}
	
	   	@ManyToOne
	    @JoinColumn(name = "idVenta")
	    private Venta venta;


		public DetalleVenta(Long idDetalleVenta, long productoId, String descripcion, int cantidad,
				double precioUnitario, double subTotal, Venta venta) {
			super();
			this.idDetalleVenta = idDetalleVenta;
			this.productoId = productoId;
			this.descripcion = descripcion;
			this.cantidad = cantidad;
			this.precioUnitario = precioUnitario;
			this.subTotal = subTotal;
			this.venta = venta;
		}


		public DetalleVenta(long productoId, String descripcion, int cantidad, double precioUnitario, double subTotal,
				Venta venta) {
			super();
			this.productoId = productoId;
			this.descripcion = descripcion;
			this.cantidad = cantidad;
			this.precioUnitario = precioUnitario;
			this.subTotal = subTotal;
			this.venta = venta;
		}


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


		public Venta getVenta() {
			return venta;
		}


		public void setVenta(Venta venta) {
			this.venta = venta;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
