package cibertec.pe.service;


import java.util.List;
import java.util.Optional;

import cibertec.pe.entites.Almacen;


public interface IAlmacenService {


    List<Almacen> findAll();


    Optional<Almacen> findById(Long id);


    Almacen save(Almacen almacen);


    Almacen update(Long id, Almacen almacen);


    void delete(Long id);

}