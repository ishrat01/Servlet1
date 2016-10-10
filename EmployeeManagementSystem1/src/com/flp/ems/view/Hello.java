package com.flp.ems.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flp.ems.service.EmployeeServiceImpl;
@WebServlet("/Hello")
public class Hello extends HttpServlet{

	private static final String ACTION_KEY = "action";
    private static final String VIEW_ALL_EMPLOYEES = "view";
    private static final String ADD_EMPLOYEE = "add";
    private static final String SAVE_EMPLOYEE = "save";
    private static final String MODIFY_EMPLOYEE = "modify";
    private static final String REMOVE_EMPLOYEE = "remove";
    static EmployeeServiceImpl service = new EmployeeServiceImpl() ;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		processRequest(request, response);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	public void processRequest(HttpServletRequest request, HttpServletResponse response) 
	{
		String actionName = request.getParameter(ACTION_KEY);
		if(VIEW_ALL_EMPLOYEES.equals(actionName))
        {            
			//HashMap<String,String>[] hashArray=service.getAllEmployee();
			PrintWriter out=null;
			
			
			String driver="com.mysql.jdbc.Driver" ;
			
			Connection con=null;
			try {
				Connection connection = 
				         DriverManager.getConnection
				            ("jdbc:mysql://localhost:8889/MeetingManagement","root","root");

				System.out.println("Connecting to database");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception");
				e.printStackTrace();
			}  
			try {
				ResultSet s=con.createStatement().executeQuery("select * from Meetings") ;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		  
			
			
//			try {
//				out = response.getWriter();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			for(HashMap a : hashArray)
//			{
//			out.println("executing");
//			//	System.out.format("%"+(a.get("id").toString().length()+5)+"s%"+(a.get("name").toString().length()+5)+"s%"+a.get("email").toString().length()+"s%"+(a.get("dob").toString().length()+5)+"s%"+(a.get("doj").toString().length()+5)+"s%"+(a.get("address").toString().length()+5)+"s", a.get("id"),a.get("name"),a.get("email"),a.get("dob").toString(),a.get("doj").toString(),a.get("address"));
//			out.println(a.get("id")+" "+a.get("name")+" "+a.get("email")+" "+a.get("dob").toString()+" "+a.get("doj").toString()+" "+a.get("address"));
//			out.flush(); 
//			out.close();
//			}
		}
        
	}

}
