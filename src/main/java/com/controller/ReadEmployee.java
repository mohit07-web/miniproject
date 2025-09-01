package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.EmployeeDto;
import com.service.EmployeeServiceImpl;


@WebServlet("/ReadEmployee")
public class ReadEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
		ArrayList<EmployeeDto> employee = employeeServiceImpl.readEmployee();
		
		request.setAttribute("data", employee);
		request.getRequestDispatcher("/WEB-INF/view/readEmployee.jsp").forward(request, response);
	}

	

}
