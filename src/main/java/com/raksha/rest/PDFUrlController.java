package com.raksha.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.raksha.entity.DownloadUrl;
import com.raksha.service.PDFDownloadService;

@RestController
@CrossOrigin
public class PDFUrlController {
	
	@Autowired
	private PDFDownloadService service;

	@GetMapping(path = "/getDownloadUrl/{id}", produces = "application/json")
	public DownloadUrl getPDFDownloadURL(@PathVariable("id") String vehicleID) {
		DownloadUrl downloadUrl=new DownloadUrl(); 
		downloadUrl.setUrl(service.getPDFDownloadURL());
		return downloadUrl;
	}
	
}

