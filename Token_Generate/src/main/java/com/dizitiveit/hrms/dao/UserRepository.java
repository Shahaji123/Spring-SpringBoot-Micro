package com.dizitiveit.hrms.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dizitiveit.hrms.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{

     
	public  Optional<User> findByUserName(String userName);
	
//	@Query(value = "select user_name from aa.user where user_name=?1",nativeQuery=true)   
//	public User findByuserName(String userName);
}
