package com.hsbg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsbg.employee.Employee;
import com.hsbg.employee.EmployeeService;

@RestController
public class SeedData {

	@Autowired
	private CompanyService companyService;
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/seeddata")
	public void seedData() {
		//Create a company
		companyService.addCompany(new Company("Hexaware", "Hexaware India Pvt. Ltd.", 100000));
		companyService.addCompany(new Company("Oracle", "Oracle India Pvt. Ltd.", 50000));
		
		employeeService.addEmployee(new Employee("Vilas", "Vilas Varghese", 50000, "Oracle"));
		employeeService.addEmployee(new Employee("Ullas", "Ullas Varghese", 70000, "Oracle"));
		
		employeeService.addEmployee(new Employee("Siji", "Siji Vilas", 90000, "Hexaware"));
		employeeService.addEmployee(new Employee("Sibi", "Sibi Vilas", 100000, "Hexaware"));


	}
}
