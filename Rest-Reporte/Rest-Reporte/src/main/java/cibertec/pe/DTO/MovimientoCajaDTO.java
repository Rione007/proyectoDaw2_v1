package cibertec.pe.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MovimientoCajaDTO {

    private Long idMovimientoCaja;
    private LocalDateTime fecha;
    private String tipo;
    private BigDecimal monto;
    private String descripcion;
    
    
    
    
    
    public MovimientoCajaDTO () {}





	public Long getIdMovimientoCaja() {
		return idMovimientoCaja;
	}





	public void setIdMovimientoCaja(Long idMovimientoCaja) {
		this.idMovimientoCaja = idMovimientoCaja;
	}





	public LocalDateTime getFecha() {
		return fecha;
	}





	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}





	public String getTipo() {
		return tipo;
	}





	public void setTipo(String tipo) {
		this.tipo = tipo;
	}





	public BigDecimal getMonto() {
		return monto;
	}





	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}





	public String getDescripcion() {
		return descripcion;
	}





	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
    
    
    
    
    
    
    
    
	
	
}
