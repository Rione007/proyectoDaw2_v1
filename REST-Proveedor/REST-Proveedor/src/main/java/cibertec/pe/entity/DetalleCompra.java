package cibertec.pe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DetalleCompra {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleCompra;

    @ManyToOne
    @JoinColumn(name="idOrdenCompra")
    private OrdenCompra ordenCompra;


    // llega del microservicio inventario (cambiar si no es igual) 
    private Long productoId;
    private Integer cantidad;
    private Double precio;
    private Double subtotal;

	
	
	public DetalleCompra () {}



	public DetalleCompra(Long idDetalleCompra, OrdenCompra ordenCompra, Long productoId, Integer cantidad,
			Double precio, Double subtotal) {
		super();
		this.idDetalleCompra = idDetalleCompra;
		this.ordenCompra = ordenCompra;
		this.productoId = productoId;
		this.cantidad = cantidad;
		this.precio = precio;
		this.subtotal = subtotal;
	}
	
	
	
	
	



	public DetalleCompra(OrdenCompra ordenCompra, Long productoId, Integer cantidad, Double precio, Double subtotal) {
		super();
		this.ordenCompra = ordenCompra;
		this.productoId = productoId;
		this.cantidad = cantidad;
		this.precio = precio;
		this.subtotal = subtotal;
	}



	public Long getIdDetalleCompra() {
		return idDetalleCompra;
	}



	public void setIdDetalleCompra(Long idDetalleCompra) {
		this.idDetalleCompra = idDetalleCompra;
	}



	public OrdenCompra getOrdenCompra() {
		return ordenCompra;
	}



	public void setOrdenCompra(OrdenCompra ordenCompra) {
		this.ordenCompra = ordenCompra;
	}



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



	public Double getPrecio() {
		return precio;
	}



	public void setPrecio(Double precio) {
		this.precio = precio;
	}



	public Double getSubtotal() {
		return subtotal;
	}



	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	
	
	
	
	
	
	
	
	
	
	
}
