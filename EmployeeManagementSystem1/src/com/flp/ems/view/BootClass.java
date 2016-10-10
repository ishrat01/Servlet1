package com.flp.ems.view;

import java.text.ParseException;
import java.util.Scanner;

import com.flp.ems.dao.EmployeeDaoImplForList;

public class BootClass {

	static Scanner scanner = new Scanner(System.in) ;
	static boolean flag=true ;
	
	public static void main(String a[]) throws ParseException
	{
		
		while(flag)
		{
			System.out.println("Enter the operation to be performed");
			System.out.println("1. Add an Employee");
			System.out.println("2. Modify details of an existing Employee");
			System.out.println("3. Remove an existing Employee");
			System.out.println("4. Search for an Employee");
			System.out.println("5. View all the Employees");
			System.out.println("6. Exit");
			menuSelection();
		}
	}
	public static void menuSelection() throws ParseException
	{
		
				System.out.println("Enter the operation to be performed");
				int choice = scanner.nextInt() ;
				
				switch(choice)
				{
				case 1:
					UserInteractions.addEmployee();
					break ;
				
				case 2: 
					UserInteractions.modifyEmployee();
					break ;
		
				case 3:
					UserInteractions.removeEmployee();
					break ;
					
				case 4:
					UserInteractions.searchEmployee();
					break ;
					
				case 5:
					UserInteractions.getAllEmployee();
					break ;
				
				case 6:
					flag=false ;
					System.exit(0) ;
					
					default:
						System.out.println("Please enter a valid choice");
				}
	
		
	}
}
