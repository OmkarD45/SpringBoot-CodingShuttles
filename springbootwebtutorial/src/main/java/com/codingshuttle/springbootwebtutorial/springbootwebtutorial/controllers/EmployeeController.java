package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
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
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name="employeeId") Long id) {
		Optional<EmployeeDTO> employeeDTO= employeeService.getEmployeeById(id);
		if(employeeDTO ==null) return ResponseEntity.notFound().build();
		return employeeDTO.map(employeeDTO1->ResponseEntity.ok(employeeDTO1)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required = false, name="inputAge") Integer age,
												@RequestParam(required = false) String sortBy){
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}
	
	@PostMapping
	public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody EmployeeDTO inputEmployee) {
		EmployeeDTO savedEmployees=employeeService.createNewEmployee(inputEmployee);
		return new ResponseEntity<>(savedEmployees,HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{employeeId}")
	public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId) {
		return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId,employeeDTO));
	}
	
	@DeleteMapping(path="/{employeeId}")
	public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeId) {
		boolean gotDeleted=employeeService.deleteEmployeeById(employeeId);
		if(gotDeleted) return ResponseEntity.ok(true);
		return ResponseEntity.notFound().build();
	}
	
	@PatchMapping(path="/{employeeId}")
	public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@RequestBody Map<String,Object> updates, @PathVariable Long employeeId) {
		EmployeeDTO employeeDTO= employeeService.updatePartialEmployeeById(employeeId,updates);
		if(employeeDTO==null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(employeeDTO);
	}
}