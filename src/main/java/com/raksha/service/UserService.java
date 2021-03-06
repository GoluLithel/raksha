package com.raksha.service;

import java.util.List;

import com.raksha.entity.User;
import com.raksha.response.OTPResponse;

public interface UserService {

	int addUser(User user);
	
	User getById(int id);
	
	List<User> getAllUser();
	
	void removeUser(int id);

	void updateUser(User user);

	public long getUserCount();

	OTPResponse verifyMail(String mail);
}
