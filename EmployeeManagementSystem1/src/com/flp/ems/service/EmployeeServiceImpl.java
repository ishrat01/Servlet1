package com.flp.ems.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.flp.ems.dao.EmployeeDaoImplForList;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.KinId;
import com.flp.ems.util.Validate;

public class EmployeeServiceImpl implements IEmployeeSrvice{
	private static int countEmp = 0 ;
	EmployeeDaoImplForList employeelist =new EmployeeDaoImplForList();
	
	
	public int generateEmpId()
	{
		int maxId=employeelist.fetchMaxId() ;
		
		return (++maxId) ;
	}
	
	
	public String generateEmail(String name,int id)
	{
		String email = "" ;
		if(id<10)
		{
			String[] fname=name.split(" ") ;
		email=fname[0]+".0"+id+"@ems.com" ;
		
		}return email ;
	}
	
	
	
	public void addEmployee(HashMap<String,String> transfer) throws ParseException 
	{
		String name=transfer.get("name") ;
		
		String address= transfer.get("address") ;
		
		long phoneNo= Integer.parseInt(transfer.get("phoneNo")) ;
		
		int id = this.generateEmpId() ;
		String email=this.generateEmail(name,id) ;
		System.out.println("generated meailid"+email);
		KinId kinid= new KinId(id, "FS"+id) ;
		
		DateFormat df = new SimpleDateFormat("dd.mm.yyyy");
		
		Date dob=df.parse(transfer.get("dob")) ;
		Date doj=df.parse(transfer.get("doj")) ;
		
		Employee employee = new Employee(name, phoneNo, dob, doj, address, 12, 12, 13) ;
		employee.setEmployeeId(id);
		employee.setKinId(kinid);
		employee.setEmailId(email);
		employeelist.addEmployee(employee);
		
 	}

	public void modifyEmployee(HashMap<String,String> modified,int idModify) 
	{
		Employee employee =employeelist.searchModifyEmployee(idModify) ;
		
		if(employee!=null)
		{
				if(modified.containsKey("name"))
				{
				
					String name=modified.get("name") ;
				
					
					employee.setName(name);
					System.out.println("modified");
				}
				
				if(modified.containsKey("address"))
				{
				
					String address= modified.get("address") ;
				
					Validate.validateAddress(address) ;
					employee.setAddress(address);
					System.out.println("modified");
				}
				
				if(modified.containsKey("phoneNo"))
				{
			
					long phoneNo= Integer.parseInt(modified.get("phoneNo")) ;
					Validate.validatePhoneNo(modified.get("phoneNo")) ;
					employee.setPhoneNo(phoneNo);
					System.out.println("modified");
				}
				
		//		if(modified.containsKey("dob"))
		//		{
		//			String dob=modified.get("dob") ;
		//		}
		//		int id = this.generateEmpId() ;
		//		System.out.println("Generated id of the employee id"+id);
		//		KinId kinid= new KinId(id, "FS"+id) ;
				
		//		DateFormat df = new SimpleDateFormat("dd.mm.yyyy");
		//		Date doj =null;
		//		Date dob=null;
		//		try {
		//			dob = df.parse(modified.get("dob"));
		//			 doj=df.parse(modified.get("doj")) ;
		//		} catch (ParseException e) {
		//			
		//		}
		//		
		//		Validate.validateDOB(dob) ;
		//		
				
				
				employeelist.modifyEmployee(employee);
		}
		else
		{
			System.out.println("Employee not found in the list");
		}
	}
	
	
	
	public boolean removeEmployee(String id) 
	{
		System.out.println("In Service");
		int idRemove=Integer.parseInt(id) ;
		boolean result=employeelist.removeEmployee(idRemove);
		return result ;
	}
	
	
	
	public HashMap<String,String>[] searchEmployee(HashMap searchMap) 
	{
		System.out.println("In service");
		ArrayList<Employee> searchedList=employeelist.searchEmployee(searchMap);
		
		HashMap<String,String> hashArray[]=new HashMap[searchedList.size()] ;
		int i=0 ;
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		
		for(Employee e:searchedList)
		{
			if(i<searchedList.size())
			{
				hashArray[i]=new HashMap<String,String>() ;
				System.out.println("ADding to hasgarary");
			hashArray[i].put("name", searchedList.get(i).getName()) ;
			hashArray[i].put("id", ""+searchedList.get(i).getEmployeeId()) ;
		hashArray[i].put("kinid", searchedList.get(i).getKinId().toString()) ;
			
			String dobString = formatter.format(searchedList.get(i).getDob());
		hashArray[i].put("dob", ""+dobString) ;
		String dojString = formatter.format(searchedList.get(i).getDoj());
			hashArray[i].put("doj", ""+dojString) ;
			hashArray[i].put("email", e.getEmailId()) ;
			hashArray[i].put("address", e.getAddress());
			i++ ;
			}
			else 
				break ;
			
			
		}
		return hashArray ;
	
	}
	public HashMap<String,String>[] getAllEmployee()
	{
		System.out.println("In service layer");
		ArrayList<Employee> list=employeelist.getAllEmployee();
		
		HashMap<String,String> hashArray[]=new HashMap[list.size()] ;
		int i=0 ;
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		
		for(Employee e:list)
		{
			if(i<list.size())
			{
				hashArray[i]=new HashMap<String,String>() ;
				System.out.println("ADding to hasgarary");
			hashArray[i].put("name", list.get(i).getName()) ;
			hashArray[i].put("id", ""+list.get(i).getEmployeeId()) ;
		hashArray[i].put("kinid", list.get(i).getKinId().toString()) ;
			
			String dobString = formatter.format(list.get(i).getDob());
		hashArray[i].put("dob", ""+dobString) ;
		String dojString = formatter.format(list.get(i).getDoj());
			hashArray[i].put("doj", ""+dojString) ;
			hashArray[i].put("email", e.getEmailId()) ;
			hashArray[i].put("address", e.getAddress());
			i++ ;
			}
			else 
				break ;
			
			
		}
		return hashArray ;
		
	}

}
