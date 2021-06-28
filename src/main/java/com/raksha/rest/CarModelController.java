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

import com.raksha.entity.CarModel;
import com.raksha.request.BikeModelRequest;
import com.raksha.request.CarModelRequest;
import com.raksha.service.CarModelService;



@RestController
@CrossOrigin
public class CarModelController {
	
	@Autowired
	private CarModelService service;
	
	@PostMapping(path = "/addcarmodel", consumes = "application/json")
	public void addCarModel(@RequestBody CarModel carmodel) {
		service.addCarModel(carmodel);
	}
	
	@GetMapping(path = "/carmodel/{id}", produces = "application/json")
	public CarModel getCarModel(@PathVariable("id") int id) {
		return service.getById(id);
	}
	
	@PostMapping(path = "/getCarId", consumes = "application/json")
	public int getIdByDetails(@RequestBody BikeModelRequest carModelReq) {
		System.out.println(carModelReq.getBrand());
		return service.getIdByDetails(carModelReq);
	}
	
	@GetMapping(path = "/carmodels", produces = "application/json")
	public List<CarModel> getAllCarModel() {
		return service.getAllCarModel();
	}
	
	@DeleteMapping(value = "/delcarmodel/{id}")
	public void deleteCarModel(@PathVariable("id") int id) {
		service.removeCarModel(id);
	}
}
