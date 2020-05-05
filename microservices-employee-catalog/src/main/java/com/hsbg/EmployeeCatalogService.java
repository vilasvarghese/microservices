package com.hsbg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.hsbg.models.CompanyEmployees;
import com.hsbg.models.Employee;
import com.hsbg.models.EmployeeRatingCatalog;
import com.hsbg.models.Rating;

@Service
public class EmployeeCatalogService {

	@Autowired
	private RestTemplate restTemplate;

	public List<EmployeeRatingCatalog> getEmployeesRating(String companyId) {
		CompanyEmployees compEmps = restTemplate
				.getForObject("http://EMPLOYEES/companies/" + companyId + "/compemployees", CompanyEmployees.class);
		int empListSize = compEmps.getEmployeeList().size();
		List<EmployeeRatingCatalog> employeesRatingList = new ArrayList<EmployeeRatingCatalog>();
		for (int i = 0; i < empListSize; i++) {
			Employee e = compEmps.getEmployeeList().get(i);
			Rating r = restTemplate.getForObject("http://RATING/ratings/employeerating/" + e.getId(), Rating.class);
			employeesRatingList.add(new EmployeeRatingCatalog(e, r));
		}
		return employeesRatingList;
	}

	public void createEmployeeRating(EmployeeRatingCatalog empRatingCatalog, String companyId) {
		restTemplate.postForObject("http://EMPLOYEES/companies/"+companyId+"/employees", empRatingCatalog.getEmployee(), Employee.class);
	}
	
	public void updateEmployeeRating(EmployeeRatingCatalog empRatingCatalog, String companyId, String employeeId) {
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("id", employeeId);
	    restTemplate.put ( "http://EMPLOYEES/companies/"+companyId+"/employees/"+employeeId , empRatingCatalog.getEmployee(), params);
	}
	
	public void deleteEmployeeRating(String employeeId) {
		Map < String, String > params = new HashMap < String, String > ();
        params.put("id", employeeId);
        restTemplate.delete("http://EMPLOYEES/employees/"+employeeId, params);
        
	}
}