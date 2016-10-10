package com.flp.ems.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class InvalidEntryException extends Exception{

	public InvalidEntryException(String message) {
		super(message);
		
	}
	
}
public class Validate 
{
	public static boolean validateName(String name)
	{
		
			if(name.matches("[A-Z][a-z]+ [A-Z][a-z]+?"))
			{
				return true ;
			}
			
			else
				return false ;


	}
	public static boolean validateAddress(String address)
	{
		if(address==null)
		{
			return false ;
		}
		return true ;
	}
	public static boolean validateDOB(String dob)
	{
		
		if(!(dob.matches("^(3[01]|[12][0-9]|0[1-9]).(1[0-2]|0[1-9]).[0-9]{4}$")))
		{
			return false ;
		}
		DateFormat df = new SimpleDateFormat("dd.mm.yyyy");
		
		Date dob_date=null;
		try {
			dob_date = df.parse(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Date d= new Date() ;
		System.out.println("current date"+d);
		if(dob_date.compareTo(d)<0)
		{
			return true ;
		} 
		return false ;
		
	}
	
	public static boolean validateDate(String date)
	{
		return true ;
	}
	
	public static boolean validatePhoneNo(String phoneNo)
	{
		
		if(phoneNo.matches("\\d")&&phoneNo.length()==10)
		{
			return false ;
		}
		return true ;
	}
	
	
	
	
	
	
}

