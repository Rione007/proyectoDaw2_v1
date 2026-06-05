package cibertec.pe.service;

import java.util.List;
import java.util.Optional;

import cibertec.pe.entity.Employee;


public interface IEmployeeService {
	
	public List<Employee> getEmployee();

    Optional<Employee> getEmployeeById(int id);

    Employee createEmployee(Employee employee);

    Employee updateEmployee(int id, Employee employee);

    void deleteEmployee(int id);

	
}
