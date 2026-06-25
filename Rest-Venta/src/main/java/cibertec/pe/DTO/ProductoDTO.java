package cibertec.pe.DTO;


public class ProductoDTO {

    private Long id;

    private String nombre;

    private Double precioVenta;


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


    public Double getPrecioVenta() {
        return precioVenta;
    }


    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

}