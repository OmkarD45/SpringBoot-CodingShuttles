package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	private final EmployeeRepository employeeRepository;
	private final ModelMapper modelMapper;	
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
		this.modelMapper = new ModelMapper();
	}
	
	public EmployeeDTO getEmployeeById(Long id) {
		EmployeeEntity employeeEntity=employeeRepository.findById(id).orElse(null);
		return modelMapper.map(employeeEntity, EmployeeDTO.class);
	}

	public List<EmployeeDTO> getAllEmployees() {
		List<EmployeeEntity> employeeEntities=employeeRepository.findAll();
		return employeeEntities.stream().map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class)).collect(Collectors.toList());
	}

	public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
		EmployeeEntity toSaveEntity=modelMapper.map(inputEmployee, EmployeeEntity.class);
		EmployeeEntity savedEmployeeEntity= employeeRepository.save(toSaveEntity);
		return modelMapper.map(savedEmployeeEntity,EmployeeDTO.class);
	}

}
