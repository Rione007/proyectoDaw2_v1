package cibertec.pe.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import cibertec.pe.entity.MovimientoCaja.TipoMovimiento;

public class MovimientoCajaDTO {

	private Long idMovimientoCaja;
	private Long idCaja;
	private LocalDateTime fecha;
	private TipoMovimiento tipo;
	private BigDecimal monto;
	private String descripcion;

	public MovimientoCajaDTO() {
	}

	public MovimientoCajaDTO(Long idMovimientoCaja, Long idCaja, LocalDateTime fecha, TipoMovimiento tipo,
			BigDecimal monto, String descripcion) {
		this.idMovimientoCaja = idMovimientoCaja;
		this.idCaja = idCaja;
		this.fecha = fecha;
		this.tipo = tipo;
		this.monto = monto;
		this.descripcion = descripcion;
	}

	public Long getIdMovimientoCaja() {
		return idMovimientoCaja;
	}

	public void setIdMovimientoCaja(Long idMovimientoCaja) {
		this.idMovimientoCaja = idMovimientoCaja;
	}

	public Long getIdCaja() {
		return idCaja;
	}

	public void setIdCaja(Long idCaja) {
		this.idCaja = idCaja;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public TipoMovimiento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimiento tipo) {
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