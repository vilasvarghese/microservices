package com.example.FirstSpringBoot;

import org.springframework.stereotype.Component;

@Component
public class Employee {

	private String name = "Default";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void print() {
		System.out.println("How are you doing?");
	}
}
