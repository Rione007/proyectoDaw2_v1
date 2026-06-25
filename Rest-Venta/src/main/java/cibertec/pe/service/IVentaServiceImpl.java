package cibertec.pe.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.DTO.DetalleVentaDTO;
import cibertec.pe.DTO.ProductoDTO;
import cibertec.pe.DTO.VentaDTO;
import cibertec.pe.entity.Cliente;
import cibertec.pe.entity.DetalleVenta;
import cibertec.pe.entity.Venta;
import cibertec.pe.feign.ProductoClient;
import cibertec.pe.repository.IClienteRepository;
import cibertec.pe.repository.IVentaRepository;

@Service
public class IVentaServiceImpl implements IVentaService {

	@Autowired
	private IVentaRepository ventaRepo;

	@Autowired
	private IClienteRepository clienteRepo;

	@Autowired
	private ProductoClient productoClient;

	@Override
	public List<Venta> findAll() {

		return ventaRepo.findAll();

	}

	@Override
	public Optional<Venta> findById(long id) {

		return ventaRepo.findById(id);

	}

	@Override
	public Venta save(Venta venta) {

		return ventaRepo.save(venta);

	}

	@Override
	public Venta crearVenta(VentaDTO dto) {

		// Buscar cliente
		Cliente cliente = clienteRepo.findById(dto.getIdCliente())
				.orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

		// Crear venta
		Venta venta = new Venta();

		venta.setCliente(cliente);

		venta.setFecha(LocalDateTime.now());

		venta.setEstado(dto.getEstado());

		double total = 0;

		List<DetalleVenta> detalles = new ArrayList<>();

		// Recorrer productos de la venta
		for (DetalleVentaDTO d : dto.getDetalles()) {

			// Consultar producto en microservicio Inventario
			ProductoDTO producto = productoClient.buscarProducto(d.getProductoId());

			if (producto == null) {

				throw new RuntimeException("Producto no encontrado: " + d.getProductoId());

			}

			DetalleVenta detalle = new DetalleVenta();

			// Guardamos el id externo del producto
			detalle.setProductoId(producto.getId());

			// Nombre que viene del microservicio
			detalle.setDescripcion(producto.getNombre());

			detalle.setCantidad(d.getCantidad());

			// Precio real del producto
			double precio = producto.getPrecioVenta();

			detalle.setPrecioUnitario(precio);

			double subtotal = precio * d.getCantidad();

			detalle.setSubTotal(subtotal);

			// Relación con venta
			detalle.setVenta(venta);

			total += subtotal;

			detalles.add(detalle);

		}

		venta.setTotal(total);

		venta.setDetalles(detalles);

		return ventaRepo.save(venta);

	}

	@Override
	public Venta update(long id, Venta venta) {

		Venta existente = ventaRepo.findById(id).orElseThrow(() -> new RuntimeException("Venta no encontrada"));

		existente.setEstado(venta.getEstado());

		return ventaRepo.save(existente);

	}

	@Override
	public void deleteById(long id) {

		ventaRepo.deleteById(id);

	}

}