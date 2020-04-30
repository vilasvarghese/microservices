package com.hsbg.employee;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeDAORepository extends CrudRepository<Employee, String>{
	public List<Employee> findByCompanyId(String companyId);
}
