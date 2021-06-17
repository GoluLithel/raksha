package com.raksha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raksha.entity.User;
import com.raksha.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public void addUser(User user) {
		repo.save(user);
	}

	@Override
	public User getById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public List<User> getAllUser() {
		return repo.findAll();
	}

	@Override
	public void removeUser(int id) {
		repo.deleteById(id);
	}

	
	@Override
	public long getUserCount() {
		// TODO Auto-generated method stub
		return repo.getUserCount();
	}

}
