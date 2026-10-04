package com.example.crudSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
/* (exclude = { DataSourceAutoConfiguration.class })
// exclude-> jab bhi application start ho wo ye dependancy use n kare */
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
		System.out.println("hello world");
	}

}
