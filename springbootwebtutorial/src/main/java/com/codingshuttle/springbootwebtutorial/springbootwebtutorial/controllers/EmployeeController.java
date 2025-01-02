package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.repositories.EmployeeRepository;

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
	
	private final EmployeeRepository employeeRepository;
	
	public EmployeeController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@GetMapping(path="/{employeeId}")
	public EmployeeEntity getEmployeeById(@PathVariable(name="employeeId") Long id) {
		return employeeRepository.findById(id).orElse(null);
	}
	
	@GetMapping
	public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false, name="inputAge") Integer age,
												@RequestParam(required = false) String sortBy){
		return employeeRepository.findAll();
	}
	
	@PostMapping
	public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee) {
		return employeeRepository.save(inputEmployee);
	}
	
	@PutMapping
	public String updateEmployee() {
		return "Update Employee: PutMapping";
	}
}