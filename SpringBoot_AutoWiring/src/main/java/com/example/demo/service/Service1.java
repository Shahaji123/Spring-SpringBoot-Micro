package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDAO;
@Service
public class Service1 {
	@Autowired
 private UserDAO user;
	public void saveUser() {
		boolean status=user.save();
		if(status) {
			System.out.println("Record successfull");
			
		}else {
			System.out.println("record unsuccessfully");
		}
		
		
	}
}
