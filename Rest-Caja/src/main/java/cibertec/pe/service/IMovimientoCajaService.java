package cibertec.pe.service;

import java.util.List;
import java.util.Optional;

import cibertec.pe.DTO.MovimientoCajaDTO;
import cibertec.pe.entity.MovimientoCaja;

public interface IMovimientoCajaService {

	List<MovimientoCajaDTO> findAll();

	Optional<MovimientoCajaDTO> findById(long codigo);

	MovimientoCajaDTO save(MovimientoCajaDTO dto);

	MovimientoCajaDTO update(long codigo, MovimientoCajaDTO dto);

	void deleteById(long codigo);

}
