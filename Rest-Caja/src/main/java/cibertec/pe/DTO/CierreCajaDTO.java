package cibertec.pe.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CierreCajaDTO {

	private Long idCierreCaja;
	private Long idAperturaCaja;
	private LocalDateTime fechaCierre;
	private BigDecimal montoFinal;
	private BigDecimal diferencia;
	private String observacion;

	public CierreCajaDTO() {
	}

	public CierreCajaDTO(Long idCierreCaja, Long idAperturaCaja, LocalDateTime fechaCierre, BigDecimal montoFinal,
			BigDecimal diferencia, String observacion) {
		this.idCierreCaja = idCierreCaja;
		this.idAperturaCaja = idAperturaCaja;
		this.fechaCierre = fechaCierre;
		this.montoFinal = montoFinal;
		this.diferencia = diferencia;
		this.observacion = observacion;
	}

	public Long getIdCierreCaja() {
		return idCierreCaja;
	}

	public void setIdCierreCaja(Long idCierreCaja) {
		this.idCierreCaja = idCierreCaja;
	}

	public Long getIdAperturaCaja() {
		return idAperturaCaja;
	}

	public void setIdAperturaCaja(Long idAperturaCaja) {
		this.idAperturaCaja = idAperturaCaja;
	}

	public LocalDateTime getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(LocalDateTime fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public BigDecimal getMontoFinal() {
		return montoFinal;
	}

	public void setMontoFinal(BigDecimal montoFinal) {
		this.montoFinal = montoFinal;
	}

	public BigDecimal getDiferencia() {
		return diferencia;
	}

	public void setDiferencia(BigDecimal diferencia) {
		this.diferencia = diferencia;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
}