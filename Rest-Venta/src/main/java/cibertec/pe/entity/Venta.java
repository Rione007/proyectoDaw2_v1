package cibertec.pe.entity;


import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Venta {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVenta;
	private LocalDateTime fecha;
	private double total;
	private String estado;
	
	public Venta ()  {}
	
	//relacion cliente
	@ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

	
	//detalle venta
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<DetalleVenta> detalles;


	public Venta(long idVenta, LocalDateTime fecha, double total, String estado, Cliente cliente,
			List<DetalleVenta> detalles) {
		super();
		this.idVenta = idVenta;
		this.fecha = fecha;
		this.total = total;
		this.estado = estado;
		this.cliente = cliente;
		this.detalles = detalles;
	}


	public Venta(LocalDateTime fecha, double total, String estado, Cliente cliente, List<DetalleVenta> detalles) {
		super();
		this.fecha = fecha;
		this.total = total;
		this.estado = estado;
		this.cliente = cliente;
		this.detalles = detalles;
	}


	public long getIdVenta() {
		return idVenta;
	}


	public void setIdVenta(long idVenta) {
		this.idVenta = idVenta;
	}


	public LocalDateTime getFecha() {
		return fecha;
	}


	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<DetalleVenta> getDetalles() {
		return detalles;
	}


	public void setDetalles(List<DetalleVenta> detalles) {
		this.detalles = detalles;
	}


	
	
	
	
	
}
