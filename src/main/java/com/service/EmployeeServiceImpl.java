package com.service;

import java.util.ArrayList;

import com.dao.EmployeeDaoImpl;
import com.dto.EmployeeDto;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public String addEmployee(EmployeeDto employeeDto) {

		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		
		return employeeDaoImpl.addEmployee(employeeDto) ;
	}

	@Override
	public ArrayList<EmployeeDto> readEmployee() {

		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		
		return employeeDaoImpl.readEmployee() ;
	}

}
