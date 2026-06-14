package cibertec.pe.service;

import java.util.List;
import java.util.Optional;

import cibertec.pe.DTO.CajaDTO;
import cibertec.pe.entity.Caja;

public interface ICajaService {

	
	
	List<CajaDTO>	 			 findAll();
	Optional<CajaDTO>           findById(long codigo);
	 CajaDTO			    	 save(CajaDTO dto);
	 CajaDTO        	       update(long codigo, CajaDTO dto);
	void 					 deleteById(long codigo);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
