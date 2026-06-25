package cibertec.pe.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cibertec.pe.DTO.MovimientoCajaDTO;

@FeignClient(name = "REST-CAJA")
public interface CajaClient {

    @GetMapping("/api/movimientoCaja/list")
    List<MovimientoCajaDTO> listarMovimientos();
}
