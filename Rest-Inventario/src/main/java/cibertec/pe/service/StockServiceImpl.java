package cibertec.pe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.DTO.StockDTO;
import cibertec.pe.entites.Almacen;
import cibertec.pe.entites.Producto;
import cibertec.pe.entites.Stock;
import cibertec.pe.repository.IStockRepository;

@Service
public class StockServiceImpl implements IStockService {

	@Autowired
	private IStockRepository repo;

	@Override
	public List<StockDTO> findAll() {

		return repo.findAll().stream().map(this::convertirDTO).toList();

	}

	@Override
	public Optional<StockDTO> findById(Long id) {

		return repo.findById(id).map(this::convertirDTO);

	}

	@Override
	public StockDTO save(StockDTO dto) {

		Stock stock = new Stock();

		stock.setCantidad(dto.getCantidad());

		Producto producto = new Producto();
		producto.setId(dto.getProductoId());

		stock.setProducto(producto);

		Almacen almacen = new Almacen();
		almacen.setId(dto.getAlmacenId());

		stock.setAlmacen(almacen);

		Stock guardado = repo.save(stock);

		return convertirDTO(guardado);

	}

	@Override
	public StockDTO update(Long id, StockDTO dto) {

		Stock stock = repo.findById(id).orElseThrow(() -> new RuntimeException("Stock no encontrado"));

		stock.setCantidad(dto.getCantidad());

		Producto producto = new Producto();
		producto.setId(dto.getProductoId());

		stock.setProducto(producto);

		Almacen almacen = new Almacen();
		almacen.setId(dto.getAlmacenId());

		stock.setAlmacen(almacen);

		return convertirDTO(repo.save(stock));

	}

	@Override
	public void delete(Long id) {

		repo.deleteById(id);

	}

	private StockDTO convertirDTO(Stock stock) {

		StockDTO dto = new StockDTO();

		dto.setId(stock.getId());

		dto.setCantidad(stock.getCantidad());

		if (stock.getProducto() != null) {
			dto.setProductoId(stock.getProducto().getId());
		}

		if (stock.getAlmacen() != null) {
			dto.setAlmacenId(stock.getAlmacen().getId());
		}

		return dto;

	}

}