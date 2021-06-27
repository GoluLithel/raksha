package com.raksha.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.raksha.entity.User;
import com.raksha.response.ViewInsuranceResponce;
import com.raksha.service.ViewInsuranceService;

@RestController
@CrossOrigin
public class InsuranceViewController {

	@Autowired
	private ViewInsuranceService service;
	
	@GetMapping(path = "/getInsuranceView/{policyNumber}", produces = "application/json")
	public ViewInsuranceResponce getInsuranceView(@PathVariable("policyNumber") int policyNumber) {
		return service.getInsuranceView(policyNumber);
	}
	
	@GetMapping(path = "/Demo/{id}", produces = "application/json")
	public String getUser(@PathVariable("id") int id) {
		return "Hi"+id;
	}
	
}
