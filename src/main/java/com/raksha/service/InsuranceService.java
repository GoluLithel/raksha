package com.raksha.service;

import java.util.List;

import com.raksha.entity.Insurance;
import com.raksha.response.InsurancesPlanResponse;

public interface InsuranceService {

	void addInsurance(Insurance insurance);

	Insurance getById(int id);

	List<Insurance> getAllInsurance();

	void removeInsurance(int id);

	List<Insurance> getInsurancesByUser(int userId);
	
	long getThirdPartyCount();
	
	long getCoprehensiveCount();
	
	long getBikeInsuraceCount();
	
	long getCarInsuranceCount();

	InsurancesPlanResponse getInsurancesPlanResponse(String vehicleType, int id);
}
