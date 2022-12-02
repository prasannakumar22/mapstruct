package com.example.mapstruct.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.mapstruct.model.Department;
import com.example.mapstruct.model.Employee;
import com.example.mapstruct.model.EmployeeDTO;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

	public EmployeeMapper mapper = Mappers.getMapper(EmployeeMapper.class);
	
	@Mapping(source="name" , target = "empName")
	@Mapping(source="age" , target = "empAge")
	@Mapping(source="grade" , target = "designation")
	@Mapping(source="departmentName" , target = "department")
	@Mapping(expression = "java(mapDepartment(emp.getDepartment()))", target = "departmentName")
	EmployeeDTO convertEmployee(Employee emp);
	
	default String mapDepartment(Department departmentName) {
		return departmentName.getName();
	}
	@Mapping(source="empName" , target = "name")
	@Mapping(source="empAge" , target = "age")
	@Mapping(source="designation" , target = "grade")
	
	@Mapping(target = "department" , expression = "java(mapDept(emp.getDepartment()))")
	Employee convertEmployeeDTO(EmployeeDTO emp);
	
	default Department mapDept(String deptname) {
		return new Department(deptname);
	}
	
	
}
