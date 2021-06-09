package com.raksha.service;

import java.util.List;

import com.raksha.entity.Bike;


public interface BikeService {

	void addbike(Bike bike);
	
	Bike getById(String id);
	
	List<Bike> getAllBike();
	
	void removeBike(String id);
}
