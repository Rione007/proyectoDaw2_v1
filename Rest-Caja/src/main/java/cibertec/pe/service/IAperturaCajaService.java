package cibertec.pe.service;

import java.util.List;
import java.util.Optional;

import cibertec.pe.DTO.AperturaCajaDTO;


public interface IAperturaCajaService {

	List<AperturaCajaDTO> findAll();

	Optional<AperturaCajaDTO> findById(long codigo);

	AperturaCajaDTO save(AperturaCajaDTO dto);

	AperturaCajaDTO update(long codigo, AperturaCajaDTO dto);

	void deleteById(long codigo);

}
