<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu</title>
</head>
<body>
<h2>Select an operation to be performed</h2>
<%@ page import="java.sql.*" %>
<%int c=0 ;
    try{
    	
Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://localhost:8889/MeetingManagement","root","root");

       Statement statement = connection.createStatement() ;
       out.println("nothing is null here") ;
       out.write("Nothing is null") ;
ResultSet resultset = null ;
       resultset =statement.executeQuery("select User,Password from User") ;
      
    }catch(Exception e)
    {
    	e.printStackTrace() ;
    }
      %>  
<form action="Hello">
<a href="Hello?action=add">Add an Employee
<a href="Hello?action=modify">Modify an existing employee
<a href="Hello?action=search">Search for an Employee
<a href="Hello?action=remove">Remove an Employee
<a href="Hello?action=view">View all Employees

<input type="submit" name="submit">
</form>

</body>
</html>