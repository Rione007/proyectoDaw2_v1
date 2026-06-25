package cibertec.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cibertec.pe.entites.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Long> {

    boolean existsByCodigo(String codigo);
}
