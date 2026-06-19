package cibertec.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.DTO.ProductoDTO;
import cibertec.pe.entity.DetalleCompra;
import cibertec.pe.feign.ProductoFeignClient;
import cibertec.pe.repository.IDetalleCompraRepository;


@Service
public class IDetalleCompraServiceImpl implements IDetalleCompraService {

	
	
	@Autowired
    private IDetalleCompraRepository repository;
	

    @Autowired
    private ProductoFeignClient productoFeign;
	
	
	@Override
	public List<DetalleCompra> listar() {
		// TODO Auto-generated method stub
		 return repository.findAll();
	}

	@Override
	public DetalleCompra buscarPorId(Long id) {
		// TODO Auto-generated method stub
	    return repository.findById(id).orElse(null);
	}

	 @Override
	    public DetalleCompra guardar(DetalleCompra detalleCompra) {

	        ProductoDTO producto =productoFeign.obtenerProducto(detalleCompra.getProductoId());

	        detalleCompra.setPrecio(producto.getPrecioCompra().doubleValue());

	        detalleCompra.setSubtotal( producto.getPrecioCompra().doubleValue() * detalleCompra.getCantidad());

	        return repository.save(detalleCompra);
	    }

	 
    @Override
    public DetalleCompra actualizar(Long id, DetalleCompra detalleCompra) {

        DetalleCompra dc = repository.findById(id).orElse(null);

        if (dc != null) {

            dc.setOrdenCompra(detalleCompra.getOrdenCompra());
            dc.setProductoId(detalleCompra.getProductoId());
            dc.setCantidad(detalleCompra.getCantidad());
            dc.setPrecio(detalleCompra.getPrecio());
            dc.setSubtotal(detalleCompra.getSubtotal());

            return repository.save(dc);
        }

        return null;
    }

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		   repository.deleteById(id);
	}

}
