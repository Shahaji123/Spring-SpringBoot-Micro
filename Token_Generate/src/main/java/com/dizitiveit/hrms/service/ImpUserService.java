package com.dizitiveit.hrms.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dizitiveit.hrms.dao.UserRepository;
import com.dizitiveit.hrms.model.User;

@Service
public class ImpUserService implements IUserService, UserDetailsService{

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	 
	@Override
	public Integer saveUser(User user) {
		
		user.setPassword(pwdEncoder.encode(user.getPassword()));
		
		 return repo.save(user).getId();		
		
	}//method
	@Override
	public User findUserName(String userName){
		Optional<User> user=repo.findByUserName(userName);
		if(user.isPresent()) {
		     return user.get();
	      }
	return null;
	}//method
	
	@Override
	public UserDetails  loadUserByUsername(String userName)throws UsernameNotFoundException {
		System.out.println("loadUserByUsername "+userName);

		User opt=findUserName(userName);
		
		if(opt==null) {
		
			throw new UsernameNotFoundException("name not found");
				//	new StringBuffer().append(" User name ").append(userName).append(" not found!").toString());
		}
		
		//User user=opt.get();
		return new org.springframework.security.core.userdetails.User(
				userName, 
				opt.getPassword(),
				opt.getRoles().stream()
				.map(role->new SimpleGrantedAuthority(role))
				.collect(Collectors.toList())
				);
		
	
	//	throw new UsernameNotFoundException("user not exits");
	}//method


}
