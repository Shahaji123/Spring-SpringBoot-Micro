package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.entity.User;
import com.nt.repository.UserRepository;

@SpringBootApplication
public class SpringBootApi2Application {

	public static void main(String[] args) {
	ConfigurableApplicationContext context=SpringApplication.run(SpringBootApi2Application.class, args);
	UserRepository ure=context.getBean(UserRepository.class);
	User entity=new User();
	entity.setUser_Id(101);
	entity.setUser_Name("shahaji");
	entity.setUser_age(15);
	entity.setUser_Phno(939273436);
	entity.setUser_Country("India");
	ure.save(entity);

	}

}
