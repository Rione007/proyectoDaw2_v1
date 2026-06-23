package cibertec.pe.DTO;

import java.time.LocalDateTime;

public class VentaDTO {

	
	
	private long idVenta;
	private LocalDateTime fecha;
	private double total;
	private String estado;
	
	
	
	
	public VentaDTO () {}




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
	
	
	
	
	
	
	
	
}
