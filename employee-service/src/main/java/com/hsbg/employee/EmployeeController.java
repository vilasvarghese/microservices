package com.hsbg.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hsbg.Company;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/companies/{companyId}/employees")
	public List<Employee> getAllEmployees(@PathVariable String companyId){
		System.out.println("Inside getAllEmployees");
		return employeeService.getAllEmployees(companyId);
	}

	@RequestMapping("/companies/{companyId}/compemployees")
	public CompanyEmployees getAllCompanyEmployees(@PathVariable String companyId){
		//Introducing a wait of more than 500 ms to simulate fault tolerance
		System.out.println("just before ");
		try {
			Thread.sleep(3000);
		}catch(Exception e) {
			System.out.println("Exception "+e.toString());
		}
		
		CompanyEmployees compEmps = new CompanyEmployees();
		compEmps.setEmployeeList(employeeService.getAllEmployees(companyId));
		return compEmps;
	}

	@RequestMapping("/companies/{companyId}/employees/{id}")
	public Optional<Employee> getEmployee(@PathVariable String companyId, @PathVariable String id){
		System.out.println("Inside getEmployee");
		return employeeService.getEmployee(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/companies/{companyId}/employees")
	public void addEmployee(@RequestBody Employee employee, @PathVariable String companyId) {
		System.out.println("Inside addEmployee");
		employee.setCompany(new Company(companyId, "",0));
		employeeService.addEmployee(employee);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/companies/{companyId}/employees/{id}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable String companyId, @PathVariable String id) {
		System.out.println("inside updateEmployee");
		employee.setCompany(new Company(companyId, "",0));
		employeeService.updateEmployee(id, employee);
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE, value="/employees/{id}")
	public void deleteEmployee(@PathVariable String id){
		System.out.println("Inside deleteEmployee");
		employeeService.deleteEmployee(id);
	}
}