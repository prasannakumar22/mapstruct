package com.example.mapstruct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapstruct.mappers.EmployeeMapper;
import com.example.mapstruct.model.Department;
import com.example.mapstruct.model.Employee;
import com.example.mapstruct.model.EmployeeDTO;

@RestController
public class MapperController {

	@Autowired
	protected EmployeeMapper mapper;
	
	@GetMapping("/convert")
	public ResponseEntity<EmployeeDTO> convertEmployee(){
		Department dept =new Department("software");
		Employee emp = new Employee("name", "25", "department", "developer",dept);
		
		emp.setDepartmentName(dept);
		EmployeeDTO dto = mapper.convertEmployee(emp);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	@GetMapping("/convertDto")
	public ResponseEntity<Employee> covnertEmployeeDTO(){
		
		EmployeeDTO dto = new EmployeeDTO("dto", "40", "software", "designation","departmentName");
		Employee emp = mapper.convertEmployeeDTO(dto);
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
}
