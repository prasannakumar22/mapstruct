package com.example.mapstruct.model;

public class Employee {

	private String name;
	private String age;
	private String departmentName;
	private String grade;
	private Department department;
	
	
	
	public Employee(String name, String age, String departmentName, String grade,Department department) {
		super();
		this.name = name;
		this.age = age;
		this.departmentName = departmentName;
		this.grade = grade;
		this.department = department;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartmentName(Department department) {
		this.department = department;
	}
	
	
	
}
