package cibertec.pe.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrdenCompra {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrdenCompra;

    
//
    @ManyToOne
    @JoinColumn(name="idProveedor")
    
    
    private Proveedor proveedor;
    private Date fecha;
    private Double total;
    private String estado;  // Pendiente,Recibido y Anulado


	
	public OrdenCompra () {}



	public OrdenCompra(Long idOrdenCompra, Proveedor proveedor, Date fecha, Double total, String estado) {
		super();
		this.idOrdenCompra = idOrdenCompra;
		this.proveedor = proveedor;
		this.fecha = fecha;
		this.total = total;
		this.estado = estado;
	}



	public OrdenCompra(Proveedor proveedor, Date fecha, Double total, String estado) {
		super();
		this.proveedor = proveedor;
		this.fecha = fecha;
		this.total = total;
		this.estado = estado;
	}



	public Long getIdOrdenCompra() {
		return idOrdenCompra;
	}



	public void setIdOrdenCompra(Long idOrdenCompra) {
		this.idOrdenCompra = idOrdenCompra;
	}



	public Proveedor getProveedor() {
		return proveedor;
	}



	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public Double getTotal() {
		return total;
	}



	public void setTotal(Double total) {
		this.total = total;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
