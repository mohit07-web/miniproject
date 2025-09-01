package com.listener;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.dao.ConnectionFactory;
import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;

@WebListener
public class EmployeeListener implements ServletContextListener {

    
   
    public void contextDestroyed(ServletContextEvent sce)  { 
    }


    public void contextInitialized(ServletContextEvent sce)  { 
    	
    	try {
    	ServletContext servletContext = sce.getServletContext();
    //	String realPath = servletContext.getRealPath("/WEB-INF/config/config.properties");
    	//System.out.println(realPath);
    
    	InputStream is = servletContext.getResourceAsStream("/WEB-INF/config/config.properties");
    	Properties properties = new Properties();
    	
			properties.load(is);
			
			String url = (String) properties.get("db.url");
			String user = (String) properties.get("db.user");
			String pass = (String) properties.get("db.pass");
			String driver = (String) properties.get("db.driver");
		
			ConnectionFactory.init(url, user, pass, driver);
			
			EmployeeDao employeeDao = new EmployeeDaoImpl();
			employeeDao.createTable();
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	
}
