package cibertec.pe.service;

import java.util.List;
import java.util.Optional;

import cibertec.pe.DTO.CierreCajaDTO;


public interface ICierreCajaService {

	List<CierreCajaDTO> findAll();

	Optional<CierreCajaDTO> findById(long codigo);

	CierreCajaDTO save(CierreCajaDTO dto);

	CierreCajaDTO update(long codigo, CierreCajaDTO dto);

	void deleteById(long codigo);

}
