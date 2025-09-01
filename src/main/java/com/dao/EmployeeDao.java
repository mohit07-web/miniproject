package com.dao;

import java.util.ArrayList;

import com.dto.EmployeeDto;

public interface EmployeeDao {

	void createTable();
	String addEmployee(EmployeeDto employeeDto);
	ArrayList<EmployeeDto> readEmployee();
}
