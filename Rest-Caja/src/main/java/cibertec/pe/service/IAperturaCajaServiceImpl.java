package cibertec.pe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.DTO.AperturaCajaDTO;
import cibertec.pe.entity.AperturaCaja;
import cibertec.pe.entity.Caja;
import cibertec.pe.repository.IAperturaCajaRepository;
import cibertec.pe.repository.ICajaRepository;

@Service
public class IAperturaCajaServiceImpl implements IAperturaCajaService {

	@Autowired
	private IAperturaCajaRepository aperturarepo;

	@Autowired
	private ICajaRepository cajaRepo;

	@Override
	public List<AperturaCajaDTO> findAll() {
		return aperturarepo.findAll().stream().map(this::toDTO).toList();
	}

	@Override
	public Optional<AperturaCajaDTO> findById(long codigo) {
		return aperturarepo.findById(codigo).map(this::toDTO);
	}

	@Override
	public AperturaCajaDTO save(AperturaCajaDTO dto) {

		AperturaCaja apertura = toEntity(dto);
		AperturaCaja saved = aperturarepo.save(apertura);

		return toDTO(saved);
	}

	@Override
	public AperturaCajaDTO update(long codigo, AperturaCajaDTO dto) {

		AperturaCaja apertura = aperturarepo.findById(codigo)
				.orElseThrow(() -> new RuntimeException("Apertura no encontrada"));

		apertura.setFechaApertura(dto.getFechaApertura());
		apertura.setMontoInicial(dto.getMontoInicial());
		apertura.setUsuario(dto.getUsuario());

		// actualizar relación caja
		Caja caja = cajaRepo.findById(dto.getIdCaja()).orElseThrow(() -> new RuntimeException("Caja no encontrada"));

		apertura.setCaja(caja);

		AperturaCaja updated = aperturarepo.save(apertura);

		return toDTO(updated);
	}

	@Override
	public void deleteById(long codigo) {
		aperturarepo.deleteById(codigo);
	}

	// mappers
	private AperturaCajaDTO toDTO(AperturaCaja a) {

		AperturaCajaDTO dto = new AperturaCajaDTO();

		dto.setIdAperturaCaja(a.getIdAperturaCaja());
		dto.setFechaApertura(a.getFechaApertura());
		dto.setMontoInicial(a.getMontoInicial());
		dto.setUsuario(a.getUsuario());

		if (a.getCaja() != null) {
			dto.setIdCaja(a.getCaja().getIdCaja());
		}

		return dto;
	}

	private AperturaCaja toEntity(AperturaCajaDTO dto) {

		Caja caja = cajaRepo.findById(dto.getIdCaja()).orElseThrow(() -> new RuntimeException("Caja no encontrada"));

		AperturaCaja a = new AperturaCaja();

		a.setFechaApertura(dto.getFechaApertura());
		a.setMontoInicial(dto.getMontoInicial());
		a.setUsuario(dto.getUsuario());
		a.setCaja(caja);

		return a;
	}
}
