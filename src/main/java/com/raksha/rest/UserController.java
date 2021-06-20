package com.raksha.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raksha.entity.User;
import com.raksha.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping(path = "/add", consumes = "application/json")
	public int addUser(@RequestBody User user) {
		return service.addUser(user);
	}
	
	@GetMapping(path = "/user/{id}", produces = "application/json")
	public User getUser(@PathVariable("id") int id) {
		return service.getById(id);
	}
	
	@GetMapping(path = "/users", produces = "application/json")
	public List<User> getAllUser() {
		return service.getAllUser();
	}
	
	@DeleteMapping(value = "/del/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		service.removeUser(id);
	}
	
//	@PostMapping(value = "/update")
//	public void updateUser(@PathVariable("id") int id) {
//		service.removeUser(id);
//	}
}
