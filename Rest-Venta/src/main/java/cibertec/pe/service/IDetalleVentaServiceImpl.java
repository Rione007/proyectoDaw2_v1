package cibertec.pe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.entity.Cliente;
import cibertec.pe.entity.DetalleVenta;
import cibertec.pe.repository.IDetalleVentaRepository;

@Service
public class IDetalleVentaServiceImpl implements IDetalleVentaService {

	
	@Autowired
	private IDetalleVentaRepository detallerepo;

	@Override
	public List<DetalleVenta> findAll() {
		// TODO Auto-generated method stub
		return detallerepo.findAll();
	}

	@Override
	public Optional<DetalleVenta> findById(long codigo) {
		// TODO Auto-generated method stub
		return	detallerepo.findById(codigo);
	}

	@Override
	public DetalleVenta save(DetalleVenta detalleVenta) {
		// TODO Auto-generated method stub
		return detallerepo.save(detalleVenta);
	}

	@Override
	public DetalleVenta update(long codigo, DetalleVenta detalleVenta) {

	    DetalleVenta existente = detallerepo.findById(codigo)
	            .orElseThrow(() -> new RuntimeException("Detalle Venta no encontrado"));

	    existente.setCantidad(detalleVenta.getCantidad());
	    existente.setPrecioUnitario(detalleVenta.getPrecioUnitario());
	    existente.setSubTotal(detalleVenta.getSubTotal());
	    existente.setDescripcion(detalleVenta.getDescripcion());

	    return detallerepo.save(existente);
	}
	
	
	
	@Override
	public void deleteById(long codigo) {
		detallerepo.deleteById(codigo);
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
