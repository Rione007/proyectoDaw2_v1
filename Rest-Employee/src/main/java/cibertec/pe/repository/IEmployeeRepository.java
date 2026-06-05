package cibertec.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cibertec.pe.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}
