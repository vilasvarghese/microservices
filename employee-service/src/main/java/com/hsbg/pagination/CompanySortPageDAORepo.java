package com.hsbg.pagination;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import com.hsbg.Company;

public interface CompanySortPageDAORepo extends PagingAndSortingRepository<Company, String> {

}
