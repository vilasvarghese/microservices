package com.hsbg.employee;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeServiceTest {

    @Mock
    private EmployeeDAORepository empRepository;

    @InjectMocks
    private EmployeeService empService = new EmployeeService();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAllEmployees() {
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee("1", "Vilas", 10000, "Hexaware"));
		when(empRepository.findAll()).thenReturn(empList);
		
		List<Employee> resultEmpList = empService.getAllEmployees("Hexaware");
		for (int i =0; i < resultEmpList.size();i++) {
			Employee emp = resultEmpList.get(i);
			assertEquals("Vilas", emp.getName(), "Name doesn't match");
		}
	}
	
	
}
