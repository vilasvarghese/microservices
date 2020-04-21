package com.hsbg.models;

public class EmployeeRatingCatalog {
	private String empName;
	private String department;
	private Integer rating;


	public EmployeeRatingCatalog() {
		super();
	}

	public EmployeeRatingCatalog(String empName, String department, Integer rating) {
		super();
		this.empName = empName;
		this.department = department;
		this.rating = rating;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getEmpName() {
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

}
