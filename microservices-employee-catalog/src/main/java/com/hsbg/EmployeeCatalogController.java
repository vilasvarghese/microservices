package com.hsbg;

import java.util.ArrayList;
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
import com.hsbg.models.Rating;

@RestController
@RequestMapping("/catalog")
public class EmployeeCatalogController {
	
	//Remember there is a Class level request mapping also out here.
	@RequestMapping("/companies/{companyId}")
	public List<EmployeeRatingCatalog> getEmployeesRating(@PathVariable String companyId){
		RestTemplate restTemplate = new RestTemplate();///
		CompanyEmployees compEmps = restTemplate.getForObject("http://EMPLOYEE-SERVICE:8081/companies/"+companyId+"/compemployees", CompanyEmployees.class);
		int empListSize = compEmps.getEmployeeList().size();
		List<EmployeeRatingCatalog> employeesRatingList = new ArrayList<EmployeeRatingCatalog>();
		for (int i =0; i < empListSize; i++) {
			Employee e = compEmps.getEmployeeList().get(i);
			Rating r = restTemplate.getForObject("http://RATING-SERVICE:8082/ratings/employeerating/"+e.getId(), Rating.class);
			employeesRatingList.add(new EmployeeRatingCatalog(e, r));
		}
		
		return employeesRatingList;
	}
}
