package cibertec.pe.entites;

import java.math.BigDecimal;
import java.util.List;

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
    private Categoria categoria;
    
    @OneToMany(mappedBy = "producto")
    private List<Stock> stocks;
    

}