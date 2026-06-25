package cibertec.pe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.DTO.ProductoDTO;
import cibertec.pe.entites.Categoria;
import cibertec.pe.entites.Producto;
import cibertec.pe.repository.ICategoriaRepository;
import cibertec.pe.repository.IProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private ICategoriaRepository categoriaRepository;
    
    
   

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto save(ProductoDTO dto) {

    	 if(productoRepository.existsByCodigo(dto.getCodigo())) {
    	        throw new RuntimeException("El código ya existe");
    	    }
    	
    	
        Categoria categoria = categoriaRepository
                .findById(dto.getCategoriaId())
                .orElseThrow(() ->
                        new RuntimeException("Categoria no encontrada"));

        Producto producto = new Producto();

        producto.setCodigo(dto.getCodigo());
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecioCompra(dto.getPrecioCompra());
        producto.setPrecioVenta(dto.getPrecioVenta());
        producto.setEstado(dto.getEstado());
        producto.setCategoria(categoria);

        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Long id, ProductoDTO dto) {

        Producto existente = productoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Producto no encontrado"));

        Categoria categoria = categoriaRepository
                .findById(dto.getCategoriaId())
                .orElseThrow(() ->
                        new RuntimeException("Categoria no encontrada"));

        existente.setCodigo(dto.getCodigo());
        existente.setNombre(dto.getNombre());
        existente.setDescripcion(dto.getDescripcion());
        existente.setPrecioCompra(dto.getPrecioCompra());
        existente.setPrecioVenta(dto.getPrecioVenta());
        existente.setEstado(dto.getEstado());
        existente.setCategoria(categoria);

        return productoRepository.save(existente);
    }

    @Override
    public void deleteById(Long id) {

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Producto no encontrado"));

        productoRepository.delete(producto);
    }
}