package com.raksha.service;

import java.util.List;

import com.raksha.entity.Admin;

public interface AdminService {

	void addAdmin(Admin admin);

	Admin getById(int id);

	List<Admin> getAllAdmin();

	void removeAdmin(int id);

}
