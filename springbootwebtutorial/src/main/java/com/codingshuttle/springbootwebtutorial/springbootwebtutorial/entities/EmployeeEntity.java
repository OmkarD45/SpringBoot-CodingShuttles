package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.entities;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employees")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	private String name;
	private String email; 
	private Integer age;
	private LocalDate doj;
	private Boolean isActive;
}