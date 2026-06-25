package cibertec.pe.entites;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String nombre;
    private String descripcion;

    private BigDecimal precioCompra;
    private BigDecimal precioVenta;

    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    @JsonIgnore
    private Categoria categoria;
    
    @OneToMany(mappedBy = "producto")
    @JsonIgnore
    private List<Stock> stocks;
    

    
    
    public Producto () {}




	public Producto(Long id, String codigo, String nombre, String descripcion, BigDecimal precioCompra,
			BigDecimal precioVenta, Boolean estado, Categoria categoria, List<Stock> stocks) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.estado = estado;
		this.categoria = categoria;
		this.stocks = stocks;
	}




	public Producto(String codigo, String nombre, String descripcion, BigDecimal precioCompra, BigDecimal precioVenta,
			Boolean estado, Categoria categoria, List<Stock> stocks) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.estado = estado;
		this.categoria = categoria;
		this.stocks = stocks;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getCodigo() {
		return codigo;
	}




	public void setCodigo(String codigo) {
		this.codigo = codigo;
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




	public BigDecimal getPrecioCompra() {
		return precioCompra;
	}




	public void setPrecioCompra(BigDecimal precioCompra) {
		this.precioCompra = precioCompra;
	}




	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}




	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}




	public Boolean getEstado() {
		return estado;
	}




	public void setEstado(Boolean estado) {
		this.estado = estado;
	}




	public Categoria getCategoria() {
		return categoria;
	}




	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}




	public List<Stock> getStocks() {
		return stocks;
	}




	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
    
    
    
    
    
    
    
    
    
}