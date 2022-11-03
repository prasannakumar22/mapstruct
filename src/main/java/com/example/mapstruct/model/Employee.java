package com.example.mapstruct.model;

public class Employee {

	private String name;
	private String age;
	private String department;
	private String grade;
	
	
	
	public Employee(String name, String age, String department, String grade) {
		super();
		this.name = name;
		this.age = age;
		this.department = department;
		this.grade = grade;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
