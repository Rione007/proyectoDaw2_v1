package cibertec.pe.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.DTO.DetalleVentaDTO;
import cibertec.pe.DTO.VentaDTO;
import cibertec.pe.entity.Cliente;
import cibertec.pe.entity.DetalleVenta;
import cibertec.pe.entity.Venta;
import cibertec.pe.repository.IClienteRepository;
import cibertec.pe.repository.IVentaRepository;

@Service
public class IVentaServiceImpl implements IVentaService {

	
	@Autowired
		private IVentaRepository ventarepo;
	
	
	@Autowired
	private IClienteRepository clienterepo;

	@Override
	public List<Venta> findAll() {
		// TODO Auto-generated method stub
		return ventarepo.findAll();
	}

	@Override
	public Optional<Venta> findById(long codigo) {
		// TODO Auto-generated method stub
		return ventarepo.findById(codigo);
	}

	@Override
	public Venta save(Venta venta) {
		// TODO Auto-generated method stub
		return ventarepo.save(venta);
	}

	
	
	
	
	
	
	@Override
	public Venta update(long codigo, Venta venta) {
		
		Venta ven = ventarepo.findById(codigo).orElseThrow(() -> new RuntimeException("Venta no encontrado"));
			
		//campos seguros para update
		ven.setEstado(venta.getEstado());
		ven.setFecha(venta.getFecha());
	
		return ventarepo.save(ven);	
	}
	@Override
	public void deleteById(long codigo) {
		ventarepo.deleteById(codigo);
		
	}

	
	
	@Override
	public Venta crearVenta(VentaDTO dto) {
		
		
		
		 //  Buscare un  cliente
        Cliente cliente = clienterepo.findById(dto.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        
        //  Creare venta
        Venta venta = new Venta();
        venta.setCliente(cliente);
        venta.setEstado(dto.getEstado());
        venta.setFecha(LocalDateTime.now());
        
        
        	//por ahora en 0 hasta conectar con Inventario
        double total = 0;
        
        
        //  Crear los detalles
        List<DetalleVenta> detalles = new ArrayList<>();

        for (DetalleVentaDTO d : dto.getDetalles()) {

            DetalleVenta detalle = new DetalleVenta();

            detalle.setProductoId(d.getProductoId());
            detalle.setCantidad(d.getCantidad());

            // consultar inventario
            double precio = 10.0; // temporal
            detalle.setPrecioUnitario(precio);

            double subtotal = precio * d.getCantidad();
            detalle.setSubTotal(subtotal);

            detalle.setVenta(venta);

            total += subtotal;

            detalles.add(detalle);
        }

        //	 asignar total y detalles
        venta.setTotal(total);
        venta.setDetalles(detalles);

        // save
        return ventarepo.save(venta);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
