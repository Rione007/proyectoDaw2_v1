package cibertec.pe.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.entites.Almacen;
import cibertec.pe.repository.IAlmacenRepository;


@Service
public class AlmacenServiceImpl implements IAlmacenService {



    @Autowired
    private IAlmacenRepository repo;



    @Override
    public List<Almacen> findAll(){

        return repo.findAll();

    }



    @Override
    public Optional<Almacen> findById(Long id){

        return repo.findById(id);

    }



    @Override
    public Almacen save(Almacen almacen){

        return repo.save(almacen);

    }



    @Override
    public Almacen update(Long id, Almacen almacen){


        Almacen a = repo.findById(id)
                .orElseThrow();


        a.setNombre(almacen.getNombre());

        a.setSucursalId(almacen.getSucursalId());


        return repo.save(a);

    }




    @Override
    public void delete(Long id){

        repo.deleteById(id);

    }

}