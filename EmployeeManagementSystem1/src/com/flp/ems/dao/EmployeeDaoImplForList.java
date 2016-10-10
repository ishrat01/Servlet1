package com.flp.ems.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.flp.ems.domain.Employee;
import com.flp.ems.domain.KinId;
import com.flp.ems.util.ConnectDatabase; ;
public class EmployeeDaoImplForList {
	ArrayList <Employee> employeeList=new ArrayList<Employee>() ;
	
	public Connection connectDatabase(){
		String driver="com.mysql.jdbc.Driver" ;
		
		Connection con=null;
		try {
			con = DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/EmployeeManagementSystem","root","");
			System.out.println("Connecting to database");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
				  
			return con ;
		
		
	}
	public int fetchMaxId()
	{
		int maxId =0;
		Statement getMaxId ;
		try {
			String query="select MAX(Employee_Id) from EmployeeTable" ;
			 getMaxId=this.connectDatabase().createStatement();
			 ResultSet result = getMaxId.executeQuery(query) ;
				while(result.next())
				{
					maxId=result.getInt(1) ;
					System.out.println("Max Id is"+maxId);
				}
				return maxId ;
//				System.out.println("Max Id is"+maxId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maxId ;
	}
	public void addEmployee(Employee employee) 
	{//phase1
		
		employeeList.add(employee) ;
		
		//Phase 2
		this.fetchMaxId() ;
		java.sql.Date sqldob = new java.sql.Date(employee.getDob().getTime()); 
		java.sql.Date sqldoj = new java.sql.Date(employee.getDoj().getTime()); 
		
		try {
			Statement insertQuery=ConnectDatabase.getConnectionObject().createStatement() ;
			String query="INSERT INTO `EmployeeTable`(Employee_Id,Name,Kin_Id,Email_Id,PhoneNo,DOB,DOJ,Address,Department_Id,Project_Id,Roles_Id) VALUE ('"+employee.getEmployeeId()+"','"+employee.getName()+"','"+employee.getKinId().toString()+"','"+employee.getEmailId()+"','"+employee.getPhoneNo()+"','"+sqldob+"','"+sqldoj+"','"+employee.getAddress()+"','"+employee.getD_id()+"','"+employee.getP_id()+"','"+employee.getR_id()+"')" ;
			insertQuery.executeUpdate(query) ;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Employee searchModifyEmployee(int id)
	{
		for(int i=0 ; i<employeeList.size() ;i++)
		{
			if(employeeList.get(i).getEmployeeId()==id)
			{
				System.out.println("Id matched at index"+i);
				return employeeList.get(i) ;
			}
			
		}
		return null ;
	}

	public void modifyEmployee(Employee employee) 
	{System.out.println("In dao");
		System.out.println("In dao");
		for(int i=0 ; i<employeeList.size() ;i++)
		{
			if(employeeList.get(i).getEmployeeId()==employee.getEmployeeId())
			{
				//employeeList.add(i, employee);
				System.out.println("Matched");
				employeeList.set(i, employee) ;
				break ;
				
			}
			
		}
		System.out.println("ok dao");
		
	}
	
	public boolean removeEmployee(int idRemove) 
	{
	//Phase1
//		for(int i=0 ; i<employeeList.size() ;i++)
//		{
//			if(employeeList.get(i).getEmployeeId()==idRemove)
//			{
//				employeeList.remove(i) ;
//				return true ;
//			}
//			
//		}
//		return false ;
		//Phase2
		
		int rows=0 ;
		try {
			Statement remove ;
			String query="delete from EmployeeTable where Employee_Id='"+idRemove+"'" ;
			 remove=this.connectDatabase().createStatement();
			   rows =remove.executeUpdate(query) ;
			  System.out.println("rows affected are "+rows);
				return (rows==1) ;
				
//				System.out.println("Max Id is"+maxId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (rows==1) ;
			
		
	}
	
	public ArrayList<Employee> searchEmployee(HashMap<String,String> searchMap) 
	{//Phase1
	/*	HashMap<String,String> searched=new HashMap<String,String>() ;
		if(searchMap.containsKey("id"))
		{
			int id=Integer.parseInt(searchMap.get("id")) ;
			
			for(Employee a:employeeList)
			{
				
				if(a.getEmployeeId()==id)
				{
				System.out.println("matched");
				searched.put("name", a.getName()) ;
				searched.put("dob", a.getDob().toString()) ;
				searched.put("doj", a.getDoj().toString()) ;
				searched.put("kinid", a.getKinId().toString()) ;

				}
		
			}
		
		}
		else if(searchMap.containsKey("name"))
		{
			String name=searchMap.get("name") ;
			for(Employee a:employeeList)
			{System.out.println("In dao");
				if(a.getName().equals(name))
				{
					System.out.println("Found");
					searched.put("name", a.getName()) ;
					searched.put("dob", a.getDob().toString()) ;
					searched.put("doj", a.getDoj().toString()) ;
					//searched.put("kinid", a.getKinId().toString()) ;
				}
		
			}
		
		}
		else if(searchMap.containsKey("kinid"))
		{
			String kinid=searchMap.get("kinid") ;
			for(Employee a:employeeList)
			{
				if(a.getKinId().toString().equals(kinid))
				{
					searched.put("name", a.getName()) ;
					searched.put("dob", a.getDob().toString()) ;
					searched.put("doj", a.getDoj().toString()) ;
					searched.put("kinid", a.getKinId().toString()) ;
				}
		
			}
		
		}
	return searched ;*/
	//Phase 2
	HashMap<String,String> searched=new HashMap<String,String>() ;
	Connection con=this.connectDatabase() ;
	
	Statement insertQuery=null ;
	ResultSet result = null;
	Employee employee=null ;
	try {
		 insertQuery=this.connectDatabase().createStatement() ;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(searchMap.containsKey("id"))
	{
		int id=Integer.parseInt(searchMap.get("id")) ;
		String query="select * from Employee where Employee_Id = '"+id+"'" ;
		try {
			result=insertQuery.executeQuery(query) ;
		
		while(result.next())
		{
			
			
			KinId kinid=new KinId(Integer.parseInt(result.getString(3).substring(3)), result.getString(3).substring(0, 3)) ;
			System.out.println("kinid"+result.getString(3).substring(0, 3));
			System.out.println(result.getString(3).substring(3));
			employee=new Employee(result.getString(2), result.getLong(5), result.getDate(6), result.getDate(7), result.getString(8), result.getInt(9), result.getInt(10), result.getInt(11)) ;
			employee.setEmployeeId(result.getInt(1));
			employee.setEmailId(result.getString(4));
			employee.setKinId(kinid);
			employeeList.add(employee) ;
	
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	else if(searchMap.containsKey("name"))
	{System.out.println("in dao");
		String name=searchMap.get("name") ;
		System.out.println("nAMW passed is"+name);
		String query="select * from Employee where Name = '"+name+"'" ;
		try {
			result=insertQuery.executeQuery(query) ;
		
		while(result.next())
		{
			System.out.println("in dao");
			
			KinId kinid=new KinId(Integer.parseInt(result.getString(3).substring(3)), result.getString(3).substring(0, 3)) ;
			System.out.println("kinid"+result.getString(3).substring(0, 3));
			System.out.println(result.getString(3).substring(3));
			employee=new Employee(result.getString(2), result.getLong(5), result.getDate(6), result.getDate(7), result.getString(8), result.getInt(9), result.getInt(10), result.getInt(11)) ;
			employee.setEmployeeId(result.getInt(1));
			employee.setEmailId(result.getString(4));
			employee.setKinId(kinid);
			employeeList.add(employee) ;
	
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	else if(searchMap.containsKey("kinid"))
	{
		String name=searchMap.get("kinid") ;
		//System.out.println("nAMW passed is"+name);
		String query="select * from Employee where kin_Id = '"+name+"'" ;
		try {
			result=insertQuery.executeQuery(query) ;
		
		while(result.next())
		{
			System.out.println("in dao");
			
			KinId kinid=new KinId(Integer.parseInt(result.getString(3).substring(3)), result.getString(3).substring(0, 3)) ;
			System.out.println("kinid"+result.getString(3).substring(0, 3));
			System.out.println(result.getString(3).substring(3));
			employee=new Employee(result.getString(2), result.getLong(5), result.getDate(6), result.getDate(7), result.getString(8), result.getInt(9), result.getInt(10), result.getInt(11)) ;
			employee.setEmployeeId(result.getInt(1));
			employee.setEmailId(result.getString(4));
			employee.setKinId(kinid);
			employeeList.add(employee) ;
	
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
//return searched ;
	
	
	return employeeList ;
	}
	
	
	
	//Phase1
	public ArrayList<Employee> getAllEmployee()
	{
//		System.out.println(employeeList.size());
//		
//		return employeeList ;
		ArrayList<Employee> employeeList=new ArrayList<Employee>() ;
		Employee employee =null;
		
		try {
			Statement remove ;
			String query="select * from Employee" ;
			System.out.println("In dao layer");
			remove=connectDatabase().createStatement() ;
					
			ResultSet result =remove.executeQuery(query) ;
			
			while(result.next())
			{
				KinId kinid=new KinId(Integer.parseInt(result.getString(3).substring(3)), result.getString(3).substring(0, 3)) ;
				System.out.println("kinid"+result.getString(3).substring(0, 3));
				System.out.println(result.getString(3).substring(3));
							employee=new Employee(result.getString(2), result.getLong(5), result.getDate(6), result.getDate(7), result.getString(8), result.getInt(9), result.getInt(10), result.getInt(11)) ;
				employee.setEmployeeId(result.getInt(1));
				employee.setEmailId(result.getString(4));
				employee.setKinId(kinid);
				employeeList.add(employee) ;
				
			}
		
			} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList ;
	}
	
	
}
