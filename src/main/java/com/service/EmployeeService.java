package com.service;

import java.util.ArrayList;

import com.dto.EmployeeDto;

public interface EmployeeService {

	String addEmployee(EmployeeDto employeeDto);
	ArrayList<EmployeeDto> readEmployee();
}
