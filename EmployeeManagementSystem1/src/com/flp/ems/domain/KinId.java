package com.flp.ems.domain;

public class KinId {
	@Override
	public String toString() {
		
		return departmentName+""+employeeId ;
	}

	int employeeId ;
	String departmentName ;
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public KinId(int employeeId, String departmentName) {
		this.employeeId = employeeId;
		this.departmentName = departmentName;
	}
	
}
