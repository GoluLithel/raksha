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

import com.raksha.entity.BikeModel;
import com.raksha.service.BikeModelService;


@RestController
@CrossOrigin
public class BikeModelController {
	
	@Autowired
	private BikeModelService service;
	
	@PostMapping(path = "/addbikemodel", consumes = "application/json")
	public void addbikemodel(@RequestBody BikeModel bikemodel) {
		service.addBikeModel(bikemodel);
	}
	
	@GetMapping(path = "/bikemodel/{id}", produces = "application/json")
	public BikeModel getBike(@PathVariable("id") int id) {
		return service.getById(id);
	}
	
	@GetMapping(path = "/bikemodels", produces = "application/json")
	public List<BikeModel> getAllBike() {
		return service.getAllBikeModel();
	}
	
	@DeleteMapping(value = "/delbikemodel/{id}")
	public void deleteBikeModel(@PathVariable("id") int id) {
		service.removeBikeModel(id);
	}

}
