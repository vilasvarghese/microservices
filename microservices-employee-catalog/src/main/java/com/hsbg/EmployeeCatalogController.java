package com.hsbg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hsbg.models.CompanyEmployees;
import com.hsbg.models.Employee;
import com.hsbg.models.EmployeeRatingCatalog;
import com.hsbg.models.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/catalog")
public class EmployeeCatalogController {

	@Autowired
	private RestTemplate restTemplate;// Avoid create a new instance for every call.
	// getRestTemplate is added in Application class.

	@Autowired
	private EmployeeCatalogService empCatalogService;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeCatalogController.class);

	// Remember there is a Class level request mapping also out here.
	@RequestMapping("/companies/{companyId}")
	@HystrixCommand(fallbackMethod = "fallbackEmployeeRating")
	public List<EmployeeRatingCatalog> getEmployeesRating(@PathVariable String companyId) {
		LOGGER.info("getEmployeesRating begin");
		return empCatalogService.getEmployeesRating(companyId);
	}

	public List<EmployeeRatingCatalog> fallbackEmployeeRating(@PathVariable String companyId) {
		System.out.println("Inside fallback method");
		return Arrays.asList(new EmployeeRatingCatalog(
				new Employee("0", "Timeout artificially created!!", 0, "Hexaware"), new Rating("0", 4)));
	}

	/*
	 * Make a POST request like below
	 * Create a company before this.
	 * url: http://localhost:8083/catalog/compandrating/Hexaware
{
    "employee": 
      {
        "id": "1",
        "name": "Vilas",
        "salary": "10000"
      },
	"rating": 
      {
        "id": "1",
        "rating": "4"
      }  
}
	 */
	@RequestMapping(method=RequestMethod.POST, value="/compandrating/{companyId}")
	public void createEmployeeRating(@RequestBody EmployeeRatingCatalog empRatingCatalog, @PathVariable String companyId) {
		empCatalogService.createEmployeeRating(empRatingCatalog, companyId);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/compandrating/{companyId}/{employeeId}")
	public void updateEmployeeRating(@RequestBody EmployeeRatingCatalog empRatingCatalog, @PathVariable String companyId, @PathVariable String employeeId) {
		empCatalogService.updateEmployeeRating(empRatingCatalog, companyId, employeeId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/compandrating/{companyId}/{employeeId}")
	public void deleteEmployeeRating(@PathVariable String companyId, @PathVariable String employeeId) {
		empCatalogService.deleteEmployeeRating(employeeId);
	}
}
