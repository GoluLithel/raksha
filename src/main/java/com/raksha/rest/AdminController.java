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

import com.raksha.entity.Admin;
import com.raksha.service.AdminService;



@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@PostMapping(path = "/addadmin", consumes = "application/json")
	public void addAdmin(@RequestBody Admin admin) {
		service.addAdmin(admin);
	}
	
	@GetMapping(path = "/admin/{id}", produces = "application/json")
	public Admin getAdmin(@PathVariable("id") int id) {
		return service.getById(id);
	}
	
	@GetMapping(path = "/admins", produces = "application/json")
	public List<Admin> getAllAdmin() {
		return service.getAllAdmin();
	}
	
	@DeleteMapping(value = "/deladmin/{id}")
	public void deleteAdmin(@PathVariable("id") int id) {
		service.removeAdmin(id);
	}

}
