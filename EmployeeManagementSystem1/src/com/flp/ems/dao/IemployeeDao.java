package com.flp.ems.dao;

import java.util.HashMap;

public interface IemployeeDao {

	public void addEmployee() ;

	public void modifyEmployee() ;
	
	public boolean removeEmployee(int idRemove) ;
	
	public void searchEmployee(HashMap searchMap) ;
	
	public void getAllEmployee() ;
	
}
