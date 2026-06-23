package cibertec.pe.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.DTO.DetalleVentaDTO;
import cibertec.pe.DTO.MovimientoCajaDTO;
import cibertec.pe.DTO.ProductoMasVendidoDTO;
import cibertec.pe.DTO.ReporteCajaDTO;
import cibertec.pe.DTO.ReporteVentasDTO;
import cibertec.pe.DTO.VentaDTO;
import cibertec.pe.feign.CajaClient;
import cibertec.pe.feign.DetalleVentaClient;


@Service
public class ReporteService {

    @Autowired
    private DetalleVentaClient ventaClient;

    @Autowired
    private DetalleVentaClient detalleVentaClient;

    
    @Autowired
    private CajaClient cajaClient;
    
    


    public List<VentaDTO> obtenerVentas() {
        return ventaClient.listarventas();
    }


    


    public ReporteCajaDTO obtenerIngresosEgresos() {

        List<MovimientoCajaDTO> movimientos =
                cajaClient.listarMovimientos();

        BigDecimal ingresos = BigDecimal.ZERO;
        BigDecimal egresos = BigDecimal.ZERO;

        for (MovimientoCajaDTO movimiento : movimientos) {

            if ("INGRESO".equals(movimiento.getTipo())) {
                ingresos = ingresos.add(movimiento.getMonto());
            }

            if ("EGRESO".equals(movimiento.getTipo())) {
                egresos = egresos.add(movimiento.getMonto());
            }
        }

        BigDecimal saldo = ingresos.subtract(egresos);

        return new ReporteCajaDTO(
                ingresos,
                egresos,
                saldo
        );
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //reporte de todas las ventas 
    public ReporteVentasDTO obtenerResumenVentas() {

        List<VentaDTO> ventas = ventaClient.listarventas();

        long cantidad = ventas.size();

        double total = ventas.stream()
                .mapToDouble(VentaDTO::getTotal)
                .sum();

        return new ReporteVentasDTO(cantidad, total);
    }
    
    
    
    
    //ventas rango de limites de fechas 
    
    public ReporteVentasDTO obtenerVentasPorRango(
            LocalDateTime inicio,
            LocalDateTime fin) {

        List<VentaDTO> ventas = ventaClient.listarventas();

        List<VentaDTO> ventasFiltradas = ventas.stream()
                .filter(v -> !v.getFecha().isBefore(inicio)
                        && !v.getFecha().isAfter(fin))
                .toList();

        long cantidad = ventasFiltradas.size();

        double total = ventasFiltradas.stream()
                .mapToDouble(VentaDTO::getTotal)
                .sum();

        return new ReporteVentasDTO(cantidad, total);
    }
    
    
    
    
    
    
    
    
    
    
    
//productos mas vendidos

    public List<ProductoMasVendidoDTO> obtenerProductosMasVendidos() {

        List<DetalleVentaDTO> detalles =
                detalleVentaClient.listarDetalles();

        Map<Long, ProductoMasVendidoDTO> mapa = new HashMap<>();

        for (DetalleVentaDTO detalle : detalles) {

            if (mapa.containsKey(detalle.getProductoId())) {

                ProductoMasVendidoDTO actual =
                        mapa.get(detalle.getProductoId());

                actual.setCantidadVendida(
                        actual.getCantidadVendida()
                        + detalle.getCantidad()
                );

            } else {

                mapa.put(
                    detalle.getProductoId(),
                    new ProductoMasVendidoDTO(
                        detalle.getProductoId(),
                        detalle.getDescripcion(),
                        detalle.getCantidad()
                    )
                );
            }
        }

        return mapa.values()
                .stream()
                .sorted((a, b) ->
                    Integer.compare(
                        b.getCantidadVendida(),
                        a.getCantidadVendida()
                    )
                )
                .toList();
    }
}