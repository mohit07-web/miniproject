package com.dto;

public class EmployeeDto {

	private String name;
	private String address;
	private int age;
	private int salary;
	
	
	
	public EmployeeDto() {

	}



	public EmployeeDto(String name, String address, int age, int salary) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
		this.salary = salary;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public int getSalary() {
		return salary;
	}



	public void setSalary(int salary) {
		this.salary = salary;
	}



	@Override
	public String toString() {
		return "EmployeeDto [name=" + name + ", address=" + address + ", age=" + age + ", salary=" + salary + "]";
	}
	
	
}