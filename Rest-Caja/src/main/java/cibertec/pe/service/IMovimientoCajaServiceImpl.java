package cibertec.pe.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.DTO.MovimientoCajaDTO;
import cibertec.pe.entity.Caja;
import cibertec.pe.entity.MovimientoCaja;
import cibertec.pe.repository.ICajaRepository;
import cibertec.pe.repository.IMovimientoCajaRepository;

@Service
public class IMovimientoCajaServiceImpl implements IMovimientoCajaService {

	@Autowired
	private IMovimientoCajaRepository movimientorepo;

	@Autowired
	private ICajaRepository cajaRepo;

	@Override
	public List<MovimientoCajaDTO> findAll() {
		return movimientorepo.findAll().stream().map(this::toDTO).toList();
	}

	@Override
	public Optional<MovimientoCajaDTO> findById(long codigo) {
		return movimientorepo.findById(codigo).map(this::toDTO);
	}

	@Override
	public MovimientoCajaDTO save(MovimientoCajaDTO dto) {

		MovimientoCaja movimiento = toEntity(dto);
		MovimientoCaja saved = movimientorepo.save(movimiento);

		return toDTO(saved);
	}

	@Override
	public MovimientoCajaDTO update(long codigo, MovimientoCajaDTO dto) {

		MovimientoCaja mov = movimientorepo.findById(codigo)
				.orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));

		mov.setFecha(dto.getFecha());
		mov.setTipo(dto.getTipo());
		mov.setMonto(dto.getMonto());
		mov.setDescripcion(dto.getDescripcion());

		if (dto.getIdCaja() != null) {
			Caja caja = cajaRepo.findById(dto.getIdCaja())
					.orElseThrow(() -> new RuntimeException("Caja no encontrada"));
			mov.setCaja(caja);
		}

		return toDTO(movimientorepo.save(mov));
	}

	@Override
	public void deleteById(long codigo) {
		movimientorepo.deleteById(codigo);
	}

	// maper
	private MovimientoCajaDTO toDTO(MovimientoCaja m) {

		MovimientoCajaDTO dto = new MovimientoCajaDTO();

		dto.setIdMovimientoCaja(m.getIdMovimientoCaja());
		dto.setFecha(m.getFecha());
		dto.setTipo(m.getTipo());
		dto.setMonto(m.getMonto());
		dto.setDescripcion(m.getDescripcion());

		if (m.getCaja() != null) {
			dto.setIdCaja(m.getCaja().getIdCaja());
		}

		return dto;
	}

	private MovimientoCaja toEntity(MovimientoCajaDTO dto) {

		MovimientoCaja m = new MovimientoCaja();

		m.setFecha(dto.getFecha() != null ? dto.getFecha() : LocalDateTime.now());
		m.setTipo(dto.getTipo());
		m.setMonto(dto.getMonto());
		m.setDescripcion(dto.getDescripcion());

		if (dto.getIdCaja() != null) {
			Caja caja = cajaRepo.findById(dto.getIdCaja())
					.orElseThrow(() -> new RuntimeException("Caja no encontrada"));
			m.setCaja(caja);
		}

		return m;
	}
}