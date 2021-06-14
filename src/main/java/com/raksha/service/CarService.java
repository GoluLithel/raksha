package com.raksha.service;

import java.util.List;

import com.raksha.entity.Car;

public interface CarService {

	void addCar(Car car);

	Car getById(String id);

	List<Car> getAllCar();

	void removeCar(String id);

}
