package cibertec.pe.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class CierreCaja {

	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCierreCaja;

    @OneToOne
    private AperturaCaja aperturaCaja;

    private LocalDateTime fechaCierre;

    private BigDecimal montoFinal;

    private BigDecimal diferencia;

    private String observacion;
	
	
	public CierreCaja () {}


	public CierreCaja(Long idCierreCaja, AperturaCaja aperturaCaja, LocalDateTime fechaCierre, BigDecimal montoFinal,
			BigDecimal diferencia, String observacion) {
		super();
		this.idCierreCaja = idCierreCaja;
		this.aperturaCaja = aperturaCaja;
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


	public AperturaCaja getAperturaCaja() {
		return aperturaCaja;
	}


	public void setAperturaCaja(AperturaCaja aperturaCaja) {
		this.aperturaCaja = aperturaCaja;
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
