package cibertec.pe.DTO;


public class StockDTO {


    private Long id;

    private Integer cantidad;

    private Long productoId;

    private Long almacenId;



    public StockDTO() {
    }



    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Integer getCantidad() {
        return cantidad;
    }


    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }


    public Long getProductoId() {
        return productoId;
    }


    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }


    public Long getAlmacenId() {
        return almacenId;
    }


    public void setAlmacenId(Long almacenId) {
        this.almacenId = almacenId;
    }

}