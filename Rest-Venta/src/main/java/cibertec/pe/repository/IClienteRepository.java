package cibertec.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cibertec.pe.entity.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {

}
