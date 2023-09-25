package com.nt.repository;

import org.springframework.data.repository.CrudRepository;

import com.nt.entity.User;

public interface UserRepository extends CrudRepository<User,Integer>{

}
