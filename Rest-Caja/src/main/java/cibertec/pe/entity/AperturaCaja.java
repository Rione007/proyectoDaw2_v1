package cibertec.pe.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class AperturaCaja {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idAperturaCaja;
	 private LocalDateTime fechaApertura;
	 private BigDecimal montoInicial;
	 private String usuario;
	 @ManyToOne
	 private Caja caja;
	 
	 
	 public AperturaCaja () {}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public AperturaCaja(Long idAperturaCaja, LocalDateTime fechaApertura, BigDecimal montoInicial, String usuario,
			Caja caja) {
		super();
		this.idAperturaCaja = idAperturaCaja;
		this.fechaApertura = fechaApertura;
		this.montoInicial = montoInicial;
		this.usuario = usuario;
		this.caja = caja;
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










	 public Caja getCaja() {
		 return caja;
	 }










	 public void setCaja(Caja caja) {
		 this.caja = caja;
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
