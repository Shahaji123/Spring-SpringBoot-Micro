package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.service.Service1;

@SpringBootApplication
public class SpringBootAutoWiringApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(SpringBootAutoWiringApplication.class, args);
		Service1 user=context.getBean(Service1.class);
		user.saveUser();
		
	}

}
