package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages="nt.dao")
public class SpringBootComponentScan2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootComponentScan2Application.class, args);
	}

}
