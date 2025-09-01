package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	

	private static HikariDataSource hikariDataSource;
	
	public static void init(String url, String user, String pass, String driver) {
		

		try {
			
			Class.forName(driver);
			HikariConfig hikariConfing= new HikariConfig();
			hikariConfing.setJdbcUrl(url);
			hikariConfing.setUsername(user);
			hikariConfing.setPassword(pass);

			 hikariDataSource = new HikariDataSource(hikariConfing);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection () throws SQLException 
	{
		return hikariDataSource.getConnection();
	}}

