package com.hsbg.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CompanyEmployees {
	@Autowired
	List<Employee> employeeList;
	
	
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
}
