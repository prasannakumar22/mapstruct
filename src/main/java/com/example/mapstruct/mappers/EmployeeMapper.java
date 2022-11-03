package com.example.mapstruct.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.mapstruct.model.Employee;
import com.example.mapstruct.model.EmployeeDTO;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

	public EmployeeMapper mapper = Mappers.getMapper(EmployeeMapper.class);
	
	@Mapping(source="name" , target = "empName")
	@Mapping(source="age" , target = "empAge")
	@Mapping(source="grade" , target = "designation")
	EmployeeDTO convertEmployee(Employee emp);
	
	@Mapping(source="empName" , target = "name")
	@Mapping(source="empAge" , target = "age")
	@Mapping(source="designation" , target = "grade")
	Employee convertEmployeeDTO(EmployeeDTO emp);
	
	
}
