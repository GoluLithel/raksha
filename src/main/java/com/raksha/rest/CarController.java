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

import com.raksha.entity.Car;
import com.raksha.service.CarService;



@RestController
@CrossOrigin
public class CarController {
	
	@Autowired
	private CarService service;
	
	@PostMapping(path = "/addcar", consumes = "application/json")
	public void addCar(@RequestBody Car car) {
		service.addCar(car);
	}
	
	@GetMapping(path = "/car/{id}", produces = "application/json")
	public Car getCar(@PathVariable("id") String id) {
		return service.getById(id);
	}
	
	@GetMapping(path = "/cars", produces = "application/json")
	public List<Car> getAllCar() {
		return service.getAllCar();
	}
	
	@DeleteMapping(value = "/delcar/{id}")
	public void deleteCar(@PathVariable("id") String id) {
		service.removeCar(id);
	}

}
