package cibertec.pe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.entity.Employee;
import cibertec.pe.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
    @Autowired
    private IEmployeeRepository repository;

    @Override
    public List<Employee> getEmployee() {
        return repository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return repository.findById(id);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        return repository.findById(id).map(emp -> {
            emp.setNom_employee(employee.getNom_employee());
            emp.setApe_employee(employee.getApe_employee());
            emp.setEmail_employee(employee.getEmail_employee());
            return repository.save(emp);
        }).orElseThrow(() -> new RuntimeException("Employee no encontrado"));
    }

    @Override
    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }
}
