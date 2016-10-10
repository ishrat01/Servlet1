package com.flp.ems.domain;

import java.util.Date;

public class Employee {
	int employeeId ;
	String name ;
	KinId  kinId ;
	String emailId ;
	long phoneNo ;
	Date dob ;
	Date doj ;
	String address ;
	int d_id ;
	int p_id ;
	int r_id ;
	
	
	public Employee(String name, long phoneNo, Date dob, Date doj, String address, int d_id, int p_id,
			int r_id) {
		this.name = name;
		this.phoneNo = phoneNo;
		this.dob = dob;
		this.doj = doj;
		this.address = address;
		this.d_id = d_id;
		this.p_id = p_id;
		this.r_id = r_id;
		
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public KinId getKinId() {
		return kinId;
	}
	public void setKinId(KinId kinId) {
		this.kinId = kinId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	
}
