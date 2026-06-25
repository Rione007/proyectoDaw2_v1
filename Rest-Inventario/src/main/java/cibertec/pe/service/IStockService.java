package cibertec.pe.service;


import java.util.List;
import java.util.Optional;

import cibertec.pe.DTO.StockDTO;


public interface IStockService {


    List<StockDTO> findAll();


    Optional<StockDTO> findById(Long id);


    StockDTO save(StockDTO stockDTO);


    StockDTO update(Long id, StockDTO stockDTO);


    void delete(Long id);


}