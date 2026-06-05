package cibertec.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cibertec.pe.entities.Sucursal;

@Repository
public interface ISucursalRepository extends JpaRepository<Sucursal, Long>{

}
