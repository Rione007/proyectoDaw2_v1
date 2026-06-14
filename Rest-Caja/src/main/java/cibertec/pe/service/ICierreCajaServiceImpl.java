package cibertec.pe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.DTO.CierreCajaDTO;
import cibertec.pe.entity.AperturaCaja;
import cibertec.pe.entity.CierreCaja;
import cibertec.pe.repository.ICierreCajaRepository;

@Service
public class ICierreCajaServiceImpl implements ICierreCajaService {
	
	
	@Autowired
    private ICierreCajaRepository cierrerepo;


    @Override
    public List<CierreCajaDTO> findAll() {
        return cierrerepo.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

   
    @Override
    public Optional<CierreCajaDTO> findById(long codigo) {
        return cierrerepo.findById(codigo)
                .map(this::toDTO);
    }


    @Override
    public CierreCajaDTO save(CierreCajaDTO dto) {

        CierreCaja cierre = toEntity(dto);
        CierreCaja saved = cierrerepo.save(cierre);

        return toDTO(saved);
    }

    @Override
    public CierreCajaDTO update(long codigo, CierreCajaDTO dto) {

        CierreCaja cierre = cierrerepo.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Cierre no encontrado"));

        cierre.setFechaCierre(dto.getFechaCierre());
        cierre.setMontoFinal(dto.getMontoFinal());
        cierre.setDiferencia(dto.getDiferencia());
        cierre.setObservacion(dto.getObservacion());

        CierreCaja updated = cierrerepo.save(cierre);

        return toDTO(updated);
    }

   
    @Override
    public void deleteById(long codigo) {
        cierrerepo.deleteById(codigo);
    }

    
    
    
    // MAPPER
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

    // MAPPER
    private CierreCaja toEntity(CierreCajaDTO dto) {

        CierreCaja c = new CierreCaja();

        c.setFechaCierre(dto.getFechaCierre());
        c.setMontoFinal(dto.getMontoFinal());
        c.setDiferencia(dto.getDiferencia());
        c.setObservacion(dto.getObservacion());

        if (dto.getIdAperturaCaja() != null) {
            AperturaCaja apertura = new AperturaCaja();
            apertura.setIdAperturaCaja(dto.getIdAperturaCaja());
            c.setAperturaCaja(apertura);
        }

        return c;
    }
}