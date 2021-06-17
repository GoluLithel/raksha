package com.raksha.service;

import java.util.List;

import com.raksha.entity.User;

public interface UserService {

	void addUser(User user);
	
	User getById(int id);
	
	List<User> getAllUser();
	
	void removeUser(int id);
	
	public long getUserCount();
}
