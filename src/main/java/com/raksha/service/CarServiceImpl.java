package com.raksha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raksha.entity.Car;
import com.raksha.repo.CarRepository;

@Service
public class CarServiceImpl implements CarService{
	
	@Autowired
	private CarRepository repo;
	
	@Override
	public void addCar(Car car) {
		repo.save(car);
	}

	@Override
	public Car getById(String id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Car> getAllCar() {
		return repo.findAll();
	}

	@Override
	public void removeCar(String id) {
		repo.deleteById(id);;
	}

}
