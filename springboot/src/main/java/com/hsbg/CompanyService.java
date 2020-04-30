package com.hsbg;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

	@Autowired
	private CompanyDAORepository companyDAORepository;
	
	public List<Company> getAllCompanies(){
		List<Company> companyList = new ArrayList<Company>();
		companyDAORepository.findAll().forEach(companyList::add);
		return companyList;
	}
	
	public Optional<Company> getCompany(String id) {
		return companyDAORepository.findById(id);
	}
	
	public void addCompany(Company company) {
		companyDAORepository.save(company);
	}
	
	public void updateCompany(String id, Company company) {
		companyDAORepository.save(company);
	}
	
	public void deleteCompany(String id) {
		companyDAORepository.deleteById(id);
	}
	
}
