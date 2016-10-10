package com.flp.ems.domain;

public class Department {

	int d_id ;
	String name ;
	public int getId() {
		return d_id;
	}
	public void setId(int id) {
		this.d_id = d_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	String description ;
}
