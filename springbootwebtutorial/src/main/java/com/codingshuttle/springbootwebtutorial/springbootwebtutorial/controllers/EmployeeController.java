package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.services.EmployeeService;

//@RestController
//public class EmployeeController {
//	
//	@GetMapping(path = "/getSecretMessage")
//	public String getMySuperSecretMessage() {
//		return "This is my secret message";
//	}
//	
//	@GetMapping(path="/employees/{employeeId}")
//	public EmployeeDTO getEmployeeById(@PathVariable Long employeeId) {
//		return new EmployeeDTO(employeeId,"Rahul","rahul123@gmail.com",23,LocalDate.of(2024, 12, 24),true);
//	}
//	
//	@GetMapping(path="/employees")
//	public String getAllEmployees(@RequestParam Integer age,@RequestParam(required = false)String sortBy){
//		return "Hi Age:"+age ;
//	}
//}


@RestController
@RequestMapping(path="employees")
public class EmployeeController {
	
//	private final EmployeeRepository employeeRepository;
//	public EmployeeController(EmployeeRepository employeeRepository) {
//		this.employeeRepository = employeeRepository;
//	}
	
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
	this.employeeService = employeeService;
}

	@GetMapping(path="/{employeeId}")
	public EmployeeDTO getEmployeeById(@PathVariable(name="employeeId") Long id) {
		return employeeService.getEmployeeById(id);
	}
	
	@GetMapping
	public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false, name="inputAge") Integer age,
												@RequestParam(required = false) String sortBy){
		return employeeService.getAllEmployees();
	}
	
	@PostMapping
	public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee) {
		return employeeService.createNewEmployee(inputEmployee);
	}
	
	@PutMapping
	public String updateEmployee() {
		return "Update Employee: PutMapping";
	}
}