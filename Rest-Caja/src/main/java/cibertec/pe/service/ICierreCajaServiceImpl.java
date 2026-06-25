package cibertec.pe.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.DTO.CierreCajaDTO;
import cibertec.pe.entity.AperturaCaja;
import cibertec.pe.entity.CierreCaja;
import cibertec.pe.repository.IAperturaCajaRepository;
import cibertec.pe.repository.ICierreCajaRepository;

@Service
public class ICierreCajaServiceImpl implements ICierreCajaService {

	@Autowired
	private ICierreCajaRepository cierrerepo;

	@Autowired
	private IAperturaCajaRepository aperturarepo;

	@Override
	public List<CierreCajaDTO> findAll() {

		return cierrerepo.findAll().stream().map(this::toDTO).toList();
	}

	@Override
	public Optional<CierreCajaDTO> findById(long codigo) {

		return cierrerepo.findById(codigo).map(this::toDTO);
	}

	@Override
	public CierreCajaDTO save(CierreCajaDTO dto) {

		CierreCaja cierre = toEntity(dto);

		// CALCULO AUTOMATICO DE DIFERENCIA
		if (cierre.getAperturaCaja() != null && cierre.getMontoFinal() != null
				&& cierre.getAperturaCaja().getMontoInicial() != null) {

			BigDecimal diferencia = cierre.getMontoFinal().subtract(cierre.getAperturaCaja().getMontoInicial());

			cierre.setDiferencia(diferencia);
		}

		CierreCaja saved = cierrerepo.save(cierre);

		return toDTO(saved);
	}

	@Override
	public CierreCajaDTO update(long codigo, CierreCajaDTO dto) {

		CierreCaja cierre = cierrerepo.findById(codigo).orElseThrow(() -> new RuntimeException("Cierre no encontrado"));

		cierre.setFechaCierre(dto.getFechaCierre());

		cierre.setMontoFinal(dto.getMontoFinal());

		cierre.setObservacion(dto.getObservacion());

		// RECALCULAR DIFERENCIA EN ACTUALIZACION

		if (cierre.getAperturaCaja() != null && cierre.getMontoFinal() != null
				&& cierre.getAperturaCaja().getMontoInicial() != null) {

			BigDecimal diferencia = cierre.getMontoFinal().subtract(cierre.getAperturaCaja().getMontoInicial());

			cierre.setDiferencia(diferencia);
		}

		CierreCaja updated = cierrerepo.save(cierre);

		return toDTO(updated);
	}

	@Override
	public void deleteById(long codigo) {

		cierrerepo.deleteById(codigo);
	}

//CONVERTIR DE ENTIDAS A DTO MOSTRAR

	private CierreCajaDTO toDTO(CierreCaja c) {

		CierreCajaDTO dto = new CierreCajaDTO();

		dto.setIdCierreCaja(c.getIdCierreCaja());

		dto.setFechaCierre(c.getFechaCierre());

		dto.setMontoFinal(c.getMontoFinal());

		dto.setDiferencia(c.getDiferencia());

		dto.setObservacion(c.getObservacion());

		if (c.getAperturaCaja() != null) {

			dto.setIdAperturaCaja(c.getAperturaCaja().getIdAperturaCaja());
		}

		return dto;
	}

	private CierreCaja toEntity(CierreCajaDTO dto) {

		CierreCaja c = new CierreCaja();

		c.setFechaCierre(dto.getFechaCierre());

		c.setMontoFinal(dto.getMontoFinal());

		c.setObservacion(dto.getObservacion());

		if (dto.getIdAperturaCaja() != null) {

			AperturaCaja apertura = aperturarepo.findById(dto.getIdAperturaCaja())
					.orElseThrow(() -> new RuntimeException("Apertura no encontrada"));

			c.setAperturaCaja(apertura);
		}

		return c;
	}

}