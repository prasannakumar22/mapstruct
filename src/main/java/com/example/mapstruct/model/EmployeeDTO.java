package com.example.mapstruct.model;

public class EmployeeDTO {
	private String empName;
	private String empAge;
	private String department;
	private String designation;
	private String departmentName;
	
	public EmployeeDTO(String empName, String empAge, String department, String designation,String departmentName) {
		super();
		this.empName = empName;
		this.empAge = empAge;
		this.department = department;
		this.designation = designation;
		this.departmentName = departmentName;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAge() {
		return empAge;
	}
	public void setEmpAge(String empAge) {
		this.empAge = empAge;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
}
