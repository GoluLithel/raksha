package com.raksha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raksha.entity.CarModel;
import com.raksha.repo.CarModelRepository;

@Service
public class CarModelServiceImpl implements CarModelService{
	
	@Autowired
	private CarModelRepository repo;
	
	@Override
	public void addCarModel(CarModel carmodel) {
		repo.save(carmodel);
	}

	@Override
	public CarModel getById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public List<CarModel> getAllCarModel() {
		return repo.findAll();
	}

	@Override
	public void removeCarModel(int id) {
		repo.deleteById(id);;
	}
	
	

}
