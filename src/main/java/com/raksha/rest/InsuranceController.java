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

import com.raksha.entity.Insurance;
import com.raksha.service.InsuranceService;



@RestController
@CrossOrigin
public class InsuranceController {
	
	@Autowired
	private InsuranceService service;
	
	@PostMapping(path = "/addinsurance", consumes = "application/json")
	public void addInsurance(@RequestBody Insurance insurance) {
		service.addInsurance(insurance);
	}
	
	@GetMapping(path = "/insurance/{id}", produces = "application/json")
	public Insurance getInsurance(@PathVariable("id") int id) {
		return service.getById(id);
	}
	
	@GetMapping(path = "/insurances", produces = "application/json")
	public List<Insurance> getAllInsurance() {
		return service.getAllInsurance();
	}
	
	@DeleteMapping(value = "/delinsurance/{id}")
	public void deleteInsurance(@PathVariable("id") int id) {
		service.removeInsurance(id);
	}

}
