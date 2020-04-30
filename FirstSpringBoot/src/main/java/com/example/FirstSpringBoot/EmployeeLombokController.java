package com.example.FirstSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeLombokController {

	@Autowired
	private EmployeeLombok emp;
	
	@RequestMapping("/hello")
	public String sayHello() {
	//Question: is it mandatory that mapping methods should return String?
		return "Hello from Vilas";
	}
	
	@RequestMapping("/lombok")
	public String lombok() {
		//EmployeeLombok emp = new EmployeeLombok();
		//emp.setName("Siji")
		emp.setName("Vilas");
		emp.setDepartment("IT");
		return emp.toString();
	}
}
