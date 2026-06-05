package cibertec.pe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cibertec.pe.entity.ApiResponse;
import cibertec.pe.entity.Employee;
import cibertec.pe.service.IEmployeeService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService empService;
	
	@GetMapping("/listarEmpleados")
	public ApiResponse<List<Employee>> getEmployees(){
		var result = empService.getEmployee();
		if(result.size() == 0) {
			var response = new ApiResponse("no se encontraron registros",null);
		}
		var response = new ApiResponse("total: "+result.size(),result);
		return response;
	}
	
//	@PostMapping("/crear")
//	public ApiResponse createEmployee(@RequestBody Employee reg) {
//		var emp = empService.createEmployee(reg);
//		
//		return 
//		
//	}
}
