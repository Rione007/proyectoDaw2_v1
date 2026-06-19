package cibertec.pe.service;

import java.util.List;

import cibertec.pe.entity.DetalleCompra;

public interface IDetalleCompraService {

    List<DetalleCompra> listar();
    DetalleCompra buscarPorId(Long id);
    DetalleCompra guardar(DetalleCompra detalleCompra);
    DetalleCompra actualizar(Long id, DetalleCompra detalleCompra);
    void eliminar(Long id);

}
