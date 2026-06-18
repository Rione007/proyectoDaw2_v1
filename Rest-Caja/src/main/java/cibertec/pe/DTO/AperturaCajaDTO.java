package cibertec.pe.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import cibertec.pe.entity.Caja;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class AperturaCajaDTO {

	private Long idAperturaCaja;
	private LocalDateTime fechaApertura;
	private BigDecimal montoInicial;
	private String usuario;
	private Long idCaja;

	public AperturaCajaDTO() {
	}

	public AperturaCajaDTO(Long idAperturaCaja, LocalDateTime fechaApertura, BigDecimal montoInicial, String usuario,
			Long idCaja) {
		this.idAperturaCaja = idAperturaCaja;
		this.fechaApertura = fechaApertura;
		this.montoInicial = montoInicial;
		this.usuario = usuario;
		this.idCaja = idCaja;
	}

	public Long getIdAperturaCaja() {
		return idAperturaCaja;
	}

	public void setIdAperturaCaja(Long idAperturaCaja) {
		this.idAperturaCaja = idAperturaCaja;
	}

	public LocalDateTime getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(LocalDateTime fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public BigDecimal getMontoInicial() {
		return montoInicial;
	}

	public void setMontoInicial(BigDecimal montoInicial) {
		this.montoInicial = montoInicial;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Long getIdCaja() {
		return idCaja;
	}

	public void setIdCaja(Long idCaja) {
		this.idCaja = idCaja;
	}
}