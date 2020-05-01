package com.hsbg.pagination;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hsbg.Company;

@Service
public class CompanySortPageService {

	@Autowired
	private CompanySortPageDAORepo companySortPageDAORepo;
	
	public Iterable<Company> findSortedCompanies(String param){
		return companySortPageDAORepo.findAll(Sort.by(param));
	}
	
	public Iterable<Company> findPagedCompanies(int from, int howMany){
		return companySortPageDAORepo.findAll(PageRequest.of(from, howMany));
	}
	
}
