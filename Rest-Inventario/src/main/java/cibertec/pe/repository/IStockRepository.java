package cibertec.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cibertec.pe.entites.Stock;

public interface IStockRepository extends JpaRepository<Stock, Long> {

}
