package com.example.FirstSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.example.*;

@SpringBootApplication
public class FirstSpringBootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FirstSpringBootApplication.class, args);
		System.out.println("Hello World!!");

		Employee emp = context.getBean(Employee.class);
		emp.print();
	}

}
