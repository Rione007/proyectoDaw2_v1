package cibertec.pe.entites;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Boolean estado;
    
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;
    
    
    
    
    public Categoria () {}




	public Categoria(Long id, String nombre, Boolean estado, List<Producto> productos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
		this.productos = productos;
	}




	public Categoria(String nombre, Boolean estado, List<Producto> productos) {
		super();
		this.nombre = nombre;
		this.estado = estado;
		this.productos = productos;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public Boolean getEstado() {
		return estado;
	}




	public void setEstado(Boolean estado) {
		this.estado = estado;
	}




	public List<Producto> getProductos() {
		return productos;
	}




	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}