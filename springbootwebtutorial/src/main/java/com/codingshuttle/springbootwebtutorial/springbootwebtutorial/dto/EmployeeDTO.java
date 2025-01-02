package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto;

import java.time.LocalDate;

public class EmployeeDTO {
	private Long id;
	private String name;
	private String email;
	private Integer age;
	private LocalDate doj;
	private Boolean isActive;
	
	public EmployeeDTO() {
		
	}
	public EmployeeDTO(Long id, String name, String email, Integer age, LocalDate doj, Boolean isActive) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.doj = doj;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	
}