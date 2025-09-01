package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dto.EmployeeDto;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void createTable() {

		try {
			
			String sql="create table if not Exists employee(sn int primary key auto_increment,"
					+ "name varchar(40),"
					+ "address varchar(100),"
					+ "age int,"
					+ "salary int)";
			
			Connection connection = ConnectionFactory.getConnection();
			Statement statement=connection.createStatement();
			statement.execute(sql);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public String addEmployee(EmployeeDto employeeDto) {

try {
			
			String sql="insert into employee (name, address, age, salary) values(?, ?, ?, ?)";
			
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, employeeDto.getName());
			ps.setString(2, employeeDto.getAddress());
			ps.setInt(3, employeeDto.getAge());
			ps.setInt(4, employeeDto.getSalary());
			int row=ps.executeUpdate();
			if(row==1) {
				return "SAVED";
			}
			else {
				return "FAILED TO SAVED";
			}
			
		} catch (Exception e) {

			e.printStackTrace();
			return "FAILED TO SAVE";
		}
	}

	@Override
	public ArrayList<EmployeeDto> readEmployee() {

		ArrayList<EmployeeDto> arrayList = new ArrayList<EmployeeDto>();
		
		try {
			
			String sql="select * from employee";
			
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				EmployeeDto employeeDto = new EmployeeDto(rs.getString("name"), rs.getString("address"), rs.getInt("age"), rs.getInt("salary"));
				arrayList.add(employeeDto);
				
			}
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		finally {
			
		return arrayList;
		}
	}

}
