package com.raksha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raksha.entity.Admin;
import com.raksha.repo.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository repo;
	
	@Override
	public void addAdmin(Admin admin) {
		repo.save(admin);
	}

	@Override
	public Admin getById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Admin> getAllAdmin() {
		return repo.findAll();
	}

	@Override
	public void removeAdmin(int id) {
		repo.deleteById(id);
	}


}
