package cibertec.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cibertec.pe.entities.Empresa;

@Repository
public interface IEmpresaRepository extends JpaRepository<Empresa, Long> {

}
