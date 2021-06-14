package com.raksha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raksha.entity.Bike;
import com.raksha.entity.User;
import com.raksha.repo.BikeRepository;


@Service
public class BikeServiceImpl implements BikeService{
	
	@Autowired
	private BikeRepository repo;
	
	@Override
	public void addbike(Bike bike) {
		repo.save(bike);
	}

	@Override
	public Bike getById(String id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Bike> getAllBike() {
		return repo.findAll();
	}

	@Override
	public void removeBike(String id) {
		repo.deleteById(id);;
	}
	

}
