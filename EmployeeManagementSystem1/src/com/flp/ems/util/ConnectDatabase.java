package com.flp.ems.util;
import java.sql.*;

public class ConnectDatabase {

	public static Connection getConnectionObject()
	{
		String driver="com.mysql.jdbc.Driver" ;
		Connection con=null;
		try {
			System.out.println("executing");
			con = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/employeemanagementsystem","root","ishrat");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
			return con ;
		
	}
}
