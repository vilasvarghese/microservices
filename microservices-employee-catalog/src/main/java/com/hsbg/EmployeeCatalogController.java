package com.hsbg;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hsbg.models.CompanyEmployees;
import com.hsbg.models.Employee;
import com.hsbg.models.EmployeeRatingCatalog;

@RestController
@RequestMapping("/catalog")
public class EmployeeCatalogController {
	
	@RequestMapping("/companies/{companyId}")
	public List<Employee> getEmployeesRating(@PathVariable String companyId){
		
		//List<Employee> getAllEmployees(@PathVariable String companyId)
		List<Employee> employeeList = Arrays.asList(
				new Employee("1", "Vilas", 123, "Freelancer"),
				new Employee("2", "George", 321, "Sr Manager")
				);
		//Rating getEmployeeRatings

		RestTemplate restTemplate = new RestTemplate();///
		CompanyEmployees compEmps = restTemplate.getForObject("http://localhost:8081/companies/"+companyId+"/compemployees", CompanyEmployees.class);
		return compEmps.getEmployeeList();
		
		/*return Collections.singletonList(
				new EmployeeRatingCatalog("Vilas", "IT", new Integer(4)));*/
	}
}
