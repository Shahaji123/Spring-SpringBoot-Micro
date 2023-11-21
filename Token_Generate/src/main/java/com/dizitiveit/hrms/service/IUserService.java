package com.dizitiveit.hrms.service;

import com.dizitiveit.hrms.model.User;

public interface IUserService {

	public Integer saveUser(User user);
	public  User findUserName(String userName);
}
