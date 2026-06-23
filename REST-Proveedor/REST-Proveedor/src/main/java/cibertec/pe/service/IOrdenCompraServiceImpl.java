package cibertec.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.DTO.OrdenCompraDTO;
import cibertec.pe.entity.OrdenCompra;
import cibertec.pe.entity.Proveedor;
import cibertec.pe.repository.IOrdenCompraRepository;
import cibertec.pe.repository.IProveedorRepository;


@Service
public class IOrdenCompraServiceImpl implements IOrdenCompraService {


    @Autowired
    private IOrdenCompraRepository repository;


    @Autowired
    private IProveedorRepository proveedorRepository;



    @Override
    public List<OrdenCompra> listar() {
        return repository.findAll();
    }



    @Override
    public OrdenCompra buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }




    @Override
    public OrdenCompra guardar(OrdenCompraDTO dto) {


        Proveedor proveedor = proveedorRepository.findById(dto.getIdProveedor())
                .orElseThrow(() -> 
                    new RuntimeException("Proveedor no encontrado"));


        OrdenCompra ordenCompra = new OrdenCompra();


        ordenCompra.setProveedor(proveedor);
        ordenCompra.setFecha(dto.getFecha());
        ordenCompra.setTotal(dto.getTotal());
        ordenCompra.setEstado(dto.getEstado());


        return repository.save(ordenCompra);
    }






    @Override
    public OrdenCompra actualizar(Long id, OrdenCompraDTO dto) {


        OrdenCompra ordenCompra = repository.findById(id)
                .orElse(null);



        if(ordenCompra != null) {


            if(dto.getIdProveedor() != null) {

                Proveedor proveedor = proveedorRepository.findById(dto.getIdProveedor())
                        .orElseThrow(() ->
                            new RuntimeException("Proveedor no encontrado"));

                ordenCompra.setProveedor(proveedor);
            }


            ordenCompra.setFecha(dto.getFecha());
            ordenCompra.setTotal(dto.getTotal());
            ordenCompra.setEstado(dto.getEstado());


            return repository.save(ordenCompra);
        }


        return null;
    }







    @Override
    public void eliminar(Long id) {

        repository.deleteById(id);

    }

}