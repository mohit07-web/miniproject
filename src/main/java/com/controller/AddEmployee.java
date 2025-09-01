package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.EmployeeDto;
import com.service.EmployeeService;
import com.service.EmployeeServiceImpl;


@WebServlet(urlPatterns = {"/viewAddEmployee","/addEmployee"})
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("/WEB-INF/view/addEmployee.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String age = request.getParameter("age");
		String salary = request.getParameter("salary");

		EmployeeDto employeeDto = new EmployeeDto(name, address, Integer.parseInt(age), Integer.parseInt(salary));
		EmployeeService employeeService= new EmployeeServiceImpl();
		String result = employeeService.addEmployee(employeeDto);
		
		request.setAttribute("msg", result);
		request.getRequestDispatcher("/WEB-INF/view/addEmployee.jsp").forward(request, response);
	}

}
