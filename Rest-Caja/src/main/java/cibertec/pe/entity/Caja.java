package cibertec.pe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Caja {
	
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long idCaja;
	  private String nombre;
	  private String descripcion;
	  private boolean activa;
	
	
	public Caja () {}


	public Caja(Long idCaja, String nombre, String descripcion, boolean activa) {
		super();
		this.idCaja = idCaja;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activa = activa;
	}

	
	
	
	
	

	public Caja(String nombre, String descripcion, boolean activa) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activa = activa;
	}


	public Long getIdCaja() {
		return idCaja;
	}


	public void setIdCaja(Long idCaja) {
		this.idCaja = idCaja;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public boolean isActiva() {
		return activa;
	}


	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
