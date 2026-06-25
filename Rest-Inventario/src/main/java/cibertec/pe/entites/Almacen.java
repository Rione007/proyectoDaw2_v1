package cibertec.pe.entites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Almacen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Long sucursalId;
    
    @OneToMany(mappedBy = "almacen")
    @JsonIgnore
    private List<Stock> stocks;
    
    
    public Almacen () {}


    
    
    
    
    
    
    

	public Almacen(String nombre, Long sucursalId, List<Stock> stocks) {
		super();
		this.nombre = nombre;
		this.sucursalId = sucursalId;
		this.stocks = stocks;
	}










	public Almacen(Long id, String nombre, Long sucursalId, List<Stock> stocks) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.sucursalId = sucursalId;
		this.stocks = stocks;
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



	public Long getSucursalId() {
		return sucursalId;
	}



	public void setSucursalId(Long sucursalId) {
		this.sucursalId = sucursalId;
	}



	public List<Stock> getStocks() {
		return stocks;
	}



	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
}