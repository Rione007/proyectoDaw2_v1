package cibertec.pe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.DTO.CajaDTO;
import cibertec.pe.entity.Caja;
import cibertec.pe.repository.ICajaRepository;

@Service
public class ICajaServiceImpl implements ICajaService {

	@Autowired
	private ICajaRepository cajarepo;

	@Override
	public List<CajaDTO> findAll() {
		return cajarepo.findAll().stream().map(this::toDTO).toList();
	}

	@Override
	public Optional<CajaDTO> findById(long codigo) {

		return cajarepo.findById(codigo).map(this::toDTO);
	}

	@Override
	public CajaDTO save(CajaDTO dto) {

		Caja caja = toEntity(dto);
		Caja saved = cajarepo.save(caja);

		return toDTO(saved);
	}

	@Override
	public CajaDTO update(long codigo, CajaDTO dto) {

		Caja caja = cajarepo.findById(codigo).orElseThrow(() -> new RuntimeException("Caja no encontrada"));

		caja.setNombre(dto.getNombre());
		caja.setDescripcion(dto.getDescripcion());
		caja.setActiva(dto.isActiva());

		return toDTO(cajarepo.save(caja));
	}

	@Override
	public void deleteById(long codigo) {
		cajarepo.deleteById(codigo);
	}

	
	//MAPPERS DATOS ENTRE LA CLASE Y EL DTO

	private CajaDTO toDTO(Caja caja) {
		CajaDTO dto = new CajaDTO();
		dto.setIdCaja(caja.getIdCaja());
		dto.setNombre(caja.getNombre());
		dto.setDescripcion(caja.getDescripcion());
		dto.setActiva(caja.isActiva());
		return dto;
	}

	private Caja toEntity(CajaDTO dto) {
		Caja caja = new Caja();
		caja.setNombre(dto.getNombre());
		caja.setDescripcion(dto.getDescripcion());
		caja.setActiva(dto.isActiva());
		return caja;
	}
}