package com.hsbg.pagination;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsbg.Company;

@RestController
public class CompanySortPageController {

	@Autowired
	private CompanySortPageService companySortPageService;
	
	@RequestMapping("/sortCompanies/{param}")
	public Iterable<Company> getSortedCompanies(@PathVariable String param){
		return companySortPageService.findSortedCompanies(param);
	}
	
	@RequestMapping("/pagedCompanies/{from}/{howMany}")
	public Iterable<Company> getPagedCompanies(@PathVariable int from, @PathVariable int howMany){
		return companySortPageService.findPagedCompanies(from, howMany);
	}
}
