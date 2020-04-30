package com.hsbg.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDAORepository employeeDAORepository;
	
	public List<Employee> getAllEmployees(String companyId){
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeDAORepository.findByCompanyId(companyId).forEach(employeeList::add);
		return employeeList;
	}
	
	public Optional<Employee> getEmployee(String id) {
		return employeeDAORepository.findById(id);
	}
	
	public void addEmployee(Employee employee) {
		employeeDAORepository.save(employee);
	}
	
	public void updateEmployee(String id, Employee employee) {
		employeeDAORepository.save(employee);
	}
	
	public void deleteEmployee(String id) {
		employeeDAORepository.deleteById(id);
	}
	
}
