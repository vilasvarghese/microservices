package com.hsbg;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {
	
	@Id
	private String id;
	private String name;
	private Integer numberOfEmployees;
	public Company() {
		super();
	}
	public Company(String id, String name, Integer numberOfEmployees) {
		super();
		this.id = id;
		this.name = name;
		this.numberOfEmployees = numberOfEmployees;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}
	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}
}
