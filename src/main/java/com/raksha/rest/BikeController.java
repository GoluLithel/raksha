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

import com.raksha.entity.Bike;
import com.raksha.service.BikeService;


@RestController
@CrossOrigin
public class BikeController {
	
	@Autowired
	private BikeService service;
	
	@PostMapping(path = "/addbike", consumes = "application/json")
	public void addbike(@RequestBody Bike bike) {
		service.addbike(bike);
	}
	
	@GetMapping(path = "/bike/{id}", produces = "application/json")
	public Bike getBike(@PathVariable("id") String id) {
		return service.getById(id);
	}
	
	@GetMapping(path = "/bikes", produces = "application/json")
	public List<Bike> getAllBike() {
		return service.getAllBike();
	}
	
	@DeleteMapping(value = "/delbike/{id}")
	public void deleteBike(@PathVariable("id") String id) {
		service.removeBike(id);
	}

}
