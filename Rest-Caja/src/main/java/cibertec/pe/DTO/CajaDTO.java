package cibertec.pe.DTO;

public class CajaDTO {

	private Long idCaja;
	private String nombre;
	private String descripcion;
	private boolean activa;

	public CajaDTO() {
	}

	public CajaDTO(Long idCaja, String nombre, String descripcion, boolean activa) {
		this.idCaja = idCaja;
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
