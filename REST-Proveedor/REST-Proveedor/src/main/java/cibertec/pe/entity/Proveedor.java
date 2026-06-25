package cibertec.pe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Proveedor {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProveedor;
	private String razonSocial;
	private String ruc;
	private String direccion;
	private String telefono;
	private String email;
	private String estado;
	
	
	
	public Proveedor () {}



	public Proveedor(long idProveedor, String razonSocial, String ruc, String direccion, String telefono, String email,
			String estado) {
		super();
		this.idProveedor = idProveedor;
		this.razonSocial = razonSocial;
		this.ruc = ruc;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.estado = estado;
	}



	public Proveedor(String razonSocial, String ruc, String direccion, String telefono, String email, String estado) {
		super();
		this.razonSocial = razonSocial;
		this.ruc = ruc;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.estado = estado;
	}



	public long getIdProveedor() {
		return idProveedor;
	}



	public void setIdProveedor(long idProveedor) {
		this.idProveedor = idProveedor;
	}



	public String getRazonSocial() {
		return razonSocial;
	}



	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}



	public String getRuc() {
		return ruc;
	}



	public void setRuc(String ruc) {
		this.ruc = ruc;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
	
	
	
	
	
	

}
