package com.raksha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raksha.entity.Bike;
import com.raksha.entity.BikeModel;
import com.raksha.repo.BikeModelRepository;

@Service
public class BikeModelServiceImpl implements BikeModelService {
	
	@Autowired
	private BikeModelRepository repo;
	
	@Override
	public void addBikeModel(BikeModel bikemodel) {
		repo.save(bikemodel);
	}

	@Override
	public BikeModel getById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public List<BikeModel> getAllBikeModel() {
		return repo.findAll();
	}

	@Override
	public void removeBikeModel(int id) {
		repo.deleteById(id);;
	}
	
	

}
