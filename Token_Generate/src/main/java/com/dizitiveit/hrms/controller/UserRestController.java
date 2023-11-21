package com.dizitiveit.hrms.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dizitiveit.hrms.model.User;
import com.dizitiveit.hrms.model.UserRequest;
import com.dizitiveit.hrms.model.UserResponse;
import com.dizitiveit.hrms.service.IUserService;
import com.dizitiveit.hrms.util.JwtUtil;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private IUserService service;
	
	@Autowired
	private JwtUtil util;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		Integer i=service.saveUser(user);
		String body="User "+i+" save successfully";
		return ResponseEntity.ok(body);
	}//method
	
	@PostMapping("/login")
	public ResponseEntity<UserResponse> loginUser(@RequestBody UserRequest request){
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(),request.getPassword()));

//		  if(a==null) {
//			  return new ResponseEntity("Sorry! Name Not Found",HttpStatus.BAD_REQUEST);
//		  }

		 String token=util.genrateToken(request.getUserName());
		return ResponseEntity.ok(new UserResponse(token," success! by shahaji "));
	}//method
	
	@PostMapping("/welcome")
	public ResponseEntity<String> accessData(Principal p){
		return ResponseEntity.ok("Hello User"+p.getName());
	}//method
	
		
	
	
	
	
}
