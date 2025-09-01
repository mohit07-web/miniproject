<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.dto.EmployeeDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>
</head>
<body>
 
 <a href ="index.html">HOME</a><br><br>
 
<%
    ArrayList<EmployeeDto> arrayList = (ArrayList<EmployeeDto>) request.getAttribute("data");
    if (arrayList != null) {
        for (EmployeeDto employeeDto : arrayList) {
%>     
            NAME: <%= employeeDto.getName() %><br>
            ADDRESS: <%= employeeDto.getAddress() %><br>
            AGE: <%= employeeDto.getAge() %><br>
            SALARY: <%= employeeDto.getSalary() %><br>
            <hr>
<%
        } 
    } else {
%>
        <p>No employee data found!</p>
<%
    }
%>

</body>
</html>
