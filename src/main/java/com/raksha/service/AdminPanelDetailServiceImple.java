package com.raksha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raksha.response.AdminPanelDetailsResponse;

@Service
@Transactional
public class AdminPanelDetailServiceImple implements AdminPanelDetailService {
	
	@Autowired
	private VisiterCountService visitorService;
	
	@Autowired
	private InsuranceService insuranseService;
	
	@Autowired
	private UserService userService;
	

	@Override
	public AdminPanelDetailsResponse getAdminPanelDetails() {
		// TODO Auto-generated method stub
		AdminPanelDetailsResponse response = new AdminPanelDetailsResponse();
		response.setVisitorCount(visitorService.getCount());
		response.setThirdPartyCount(insuranseService.getThirdPartyCount());
		response.setUserCount(userService.getUserCount());//
		response.setComprehensiveCount(insuranseService.getCoprehensiveCount());
		return response;
	}

}
