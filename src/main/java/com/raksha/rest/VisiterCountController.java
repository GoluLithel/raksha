package com.raksha.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raksha.service.VisiterCountService;

@RestController
@CrossOrigin
public class VisiterCountController {
	
	@Autowired
	private VisiterCountService service;
	
	@GetMapping(path = "/visitercount", produces = "application/json")
	public int getVisiterCount() {
		return service.getCount();
	}
	
	@GetMapping(path = "/incrementcount", produces = "application/json")
	public void setIncrementCount() {
		service.incrementCount();
	}

}
