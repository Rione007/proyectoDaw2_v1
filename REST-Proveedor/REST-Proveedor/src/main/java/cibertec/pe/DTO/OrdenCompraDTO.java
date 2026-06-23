package cibertec.pe.DTO;

import java.sql.Date;

public class OrdenCompraDTO {

    private Long idOrdenCompra;
    private Long idProveedor;
    private Date fecha;
    private Double total;
    private String estado;


    public OrdenCompraDTO() {}


    public OrdenCompraDTO(Long idOrdenCompra, Long idProveedor, Date fecha, Double total, String estado) {
        this.idOrdenCompra = idOrdenCompra;
        this.idProveedor = idProveedor;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
    }


    public Long getIdOrdenCompra() {
        return idOrdenCompra;
    }


    public void setIdOrdenCompra(Long idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }


    public Long getIdProveedor() {
        return idProveedor;
    }


    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }


    public Date getFecha() {
        return fecha;
    }


    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public Double getTotal() {
        return total;
    }


    public void setTotal(Double total) {
        this.total = total;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }
}