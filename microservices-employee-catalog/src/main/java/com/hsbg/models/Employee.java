package com.hsbg.models;


public class Employee {

	private String id;
	private String name;
	private Integer salary;

	//private Company company;
	
	public Employee() {
		super();
	}
	public Employee(String id, String name, Integer salary, String companyId) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		//this.company = new Company(companyId, "",0);
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
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	/*public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}*/

}
