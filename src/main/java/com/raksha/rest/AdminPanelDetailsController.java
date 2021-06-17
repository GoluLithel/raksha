package com.raksha.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raksha.response.AdminPanelDetailsResponse;
import com.raksha.service.AdminPanelDetailService;

@RestController
@CrossOrigin
public class AdminPanelDetailsController {
	
	@Autowired
	private AdminPanelDetailService service;

	@GetMapping(path = "/adminPanelDetails", produces = "application/json")
	public AdminPanelDetailsResponse getAdmin() {
		return service.getAdminPanelDetails();
	}
	
}
