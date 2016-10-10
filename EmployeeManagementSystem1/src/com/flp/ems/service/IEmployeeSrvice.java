package com.flp.ems.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import com.flp.ems.domain.Employee;

public interface IEmployeeSrvice {
	public void addEmployee(HashMap<String,String> transfer) throws ParseException ;

	public void modifyEmployee(HashMap<String,String> modified,int id) ;
	
	public boolean removeEmployee(String id) ;
	
	public HashMap<String,String>[] searchEmployee(HashMap searchMap) ;
	
	public HashMap<String,String>[] getAllEmployee() ;
	

}
