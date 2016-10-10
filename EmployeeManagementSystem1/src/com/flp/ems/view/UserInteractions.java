package com.flp.ems.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.flp.ems.service.EmployeeServiceImpl;
import com.flp.ems.util.Validate;

import sun.print.resources.serviceui;

public class UserInteractions {
	static Scanner scanner = new Scanner(System.in) ;
	static HashMap<String,String> transfer = new HashMap<String,String>() ;
	static EmployeeServiceImpl service = new EmployeeServiceImpl() ;
	
	public static void addEmployee() throws ParseException
	{
		
		System.out.println("Enter the details of the Employee to be added");
		
		
		System.out.println("Enter the name of the Employee");
				String name=scanner.nextLine() ;
				boolean flag = Validate.validateName(name) ;
				
				while(!flag)
				{
					System.out.println("Invalid Name, Please Enter a valid name for the employee") ;
					name=scanner.nextLine();
					flag=Validate.validateName(name) ;
				}
			
				flag=true ;
		System.out.println("Enter the phone number of the Employee");
				String phoneNo=scanner.next() ;
				flag=Validate.validatePhoneNo(phoneNo) ;
				
				while(!flag)
				{
					System.out.println("Invalid phone no, Please Enter a valid phone no for the employee") ;
					phoneNo=scanner.next();
					flag=Validate.validateName(phoneNo) ;
				}
		
		System.out.println("Enter the date of birth of Employee");
		String dob = scanner.next() ;
		
				flag=Validate.validateDOB(dob);
	
				while(!flag)
				{
					System.out.println("Please enter a valid date");
					dob=scanner.next() ;
					flag=Validate.validateDOB(dob) ;
				}
		
		System.out.println("Enter the date of joining of Employee");
		String doj=scanner.next() ;

		flag=Validate.validateDOB(doj);

		while(!flag)
		{
			System.out.println("Please enter a valid date");
			doj=scanner.next() ;
			flag=Validate.validateDOB(doj) ;
		}
		
		System.out.println("Enter the address of Employee");
		String address=scanner.next() ;
		flag=Validate.validateAddress(address) ;

		while(!flag)
		{
			System.out.println("Please enter a valid address");
			doj=scanner.next() ;
			flag=Validate.validateAddress(address) ;
		}
		
		transfer.put("name", name) ;
		transfer.put("phoneNo", phoneNo) ;
		transfer.put("address", address) ;
		transfer.put("doj", doj) ;
		transfer.put("dob", dob) ;
		
		service.addEmployee(transfer);
	}
	public static void modifyEmployee()
	{
//		getAllEmployee();
		System.out.println("From the list enter id of the employee whose details are to be modified") ;
		int idModigy=Integer.parseInt(scanner.next()) ;
		
		System.out.println("Select fild to be edited") ;
		System.out.println("1. Name");
		System.out.println("2. Phone Number");
		System.out.println("3. Address");
		System.out.println("4. Date of Birth");
		System.out.println("5. Date of Joining");
		
		int choice; 
		boolean flag =true ;
		while(flag)
		{
			
			choice=scanner.nextInt() ;
			scanner.nextLine() ;
			
			switch(choice)
			{
			
			case 1:
//				
//				String name=scanner.next() ;
//				transfer.put("name", name) ;
//				break ;
				System.out.println("Enter Name");
				String name=scanner.nextLine() ;
				System.out.println("Name entered is"+name);
				boolean validate_Flag = Validate.validateName(name) ;
				
				while(!validate_Flag)
				{
					System.out.println("Invalid Name, Please Enter a valid name for the employee") ;
					name=scanner.nextLine();
					System.out.println("Name entered is"+name);
					flag=Validate.validateName(name) ;
				}
				transfer.put("name", name) ;
				break ;
			case 2:
				System.out.println("Enter Phone Number");
				String phoneNo=scanner.next() ;
				transfer.put("phoneNo", phoneNo) ;
				break ;
			case 3:
				System.out.println("Enter Address");
				String address=scanner.next() ;
				transfer.put("address", address) ;
				break ;
			case 4:
				System.out.println("Enter Date of Borth");
				String dob=scanner.next() ;
				transfer.put("dob", dob) ;
				break ;
			case 5:
				System.out.println("Enter Date of Joining");
				String doj=scanner.next() ;
				transfer.put("doj", doj) ;
				break ;
				default:
				
					flag=false ;
					
					break ;
				
			}
			System.out.println("Again enter choice") ;
		}
			
		service.modifyEmployee(transfer,idModigy);
		
		}
		
		
	
	public static void removeEmployee()
	{
		//getAllEmployee();
	 System.out.println("Enter the id of the employee to ne deleted") ;
	 String id=scanner.next() ;
	 boolean result=service.removeEmployee(id);
	 if(!result)
	 {
		 System.out.println("Employee to be removed not found");
	 }
	}
	
	public static  void searchEmployee()
	{
		HashMap<String,String> searchMap=new HashMap<String,String>() ;
		System.out.println("Enter Criteria through which you want to search") ;
		System.out.println("1. Id");
		System.out.println("2. Name");
		System.out.println("3. KinId");
		HashMap<String,String>[] searched=null;//=new HashMap<String,String>() ;
		int choice=scanner.nextInt() ;
		
		switch(choice)
		{
		case 1:
			System.out.println("Enter id");
			int id=scanner.nextInt() ;
			searchMap.put("id", ""+id) ;
			searched=service.searchEmployee(searchMap) ;
			break ;
		case 2:
			System.out.println("Enter Name");
			String name=scanner.next()+" "+scanner.next() ;
			System.out.println("in ui"+name);
			searchMap.put("name", name) ;
			System.out.println("In ui");
			searched=service.searchEmployee(searchMap) ;
			break ;
		case 3:
			System.out.println("Enter kinid");
			String kinid=scanner.next() ;
			searchMap.put("kinid", kinid) ;
			searched=service.searchEmployee(searchMap) ;
			break ;
		}
		for(HashMap<String,String> a : searched)
		{
			//System.out.println("executing");
			System.out.format("%"+(a.get("id").toString().length()+5)+"s%"+(a.get("name").toString().length()+5)+"s%"+a.get("email").toString().length()+"s%"+(a.get("dob").toString().length()+5)+"s%"+(a.get("doj").toString().length()+5)+"s%"+(a.get("address").toString().length()+5)+"s", a.get("id"),a.get("name"),a.get("email"),a.get("dob").toString(),a.get("doj").toString(),a.get("address"));
			//System.out.println(a.get("id")+" "+a.get("name")+" "+a.get("email")+" "+a.get("dob").toString()+" "+a.get("doj").toString()+" "+a.get("address"));
		}
		
	}
	public static void getAllEmployee()
	{
		HashMap<String,String>[] hashArray=service.getAllEmployee();
		
		System.out.format("%10s%10s%10s%10s%10s%20s", "EmployeeId", "Name", "Email","Dob","Doj","Address");
		System.out.println("\n");
		for(HashMap a : hashArray)
		{
			System.out.println("executing");
			System.out.format("%"+(a.get("id").toString().length()+5)+"s%"+(a.get("name").toString().length()+5)+"s%"+a.get("email").toString().length()+"s%"+(a.get("dob").toString().length()+5)+"s%"+(a.get("doj").toString().length()+5)+"s%"+(a.get("address").toString().length()+5)+"s", a.get("id"),a.get("name"),a.get("email"),a.get("dob").toString(),a.get("doj").toString(),a.get("address"));
			//System.out.println(a.get("id")+" "+a.get("name")+" "+a.get("email")+" "+a.get("dob").toString()+" "+a.get("doj").toString()+" "+a.get("address"));
		}
	}
}
