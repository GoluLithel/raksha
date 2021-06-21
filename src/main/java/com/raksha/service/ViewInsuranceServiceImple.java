package com.raksha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raksha.entity.Insurance;
import com.raksha.entity.User;
import com.raksha.entity.Vehicle;
import com.raksha.entity.VehicleModel;
import com.raksha.response.ViewInsuranceResponce;

@Service
public class ViewInsuranceServiceImple implements ViewInsuranceService {
	
	
	@Autowired
	private BikeService bikeService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private CarModelService carModelService;
	
	@Autowired
	private BikeModelService  bikeModelService;
	
	@Autowired
	private InsuranceService  insuranceService;
	

	@Override
	public ViewInsuranceResponce getInsuranceView(int policyNumber) {
		// TODO Auto-generated method stub
		
		Insurance insurance = insuranceService.getById(policyNumber) ;
		User user = userService.getById(insurance.getUser_id());
		Vehicle vehicle = null;
		VehicleModel vehicleModel = null;
		if(insurance.getVehicleType().equals("Bike")) {
			vehicle = bikeService.getById(insurance.getVehicle_no());
			vehicleModel = bikeModelService.getById(vehicle.getVehicleModel());
		}else {
			vehicle = carService.getById(insurance.getVehicle_no());
			vehicleModel = carModelService.getById(vehicle.getVehicleModel());
		}
		
		ViewInsuranceResponce res = new ViewInsuranceResponce(policyNumber);
		
		res.setPolicyNumber(policyNumber);
		res.setUserFname(user.getFname());
		res.setUserMname(user.getMname());
		res.setUserLname(user.getLname());
		res.setUserEmail(user.getGmail());
		res.setUserPhone(user.getMobileNo());
		res.setUserPhotoIdType(user.getPhotoIdType());
		res.setUserPhotoIdNumber(user.getPhotoId());
		res.setVehicleType(vehicle.getClass().toString());
		res.setVehicleRegistrationNumber(vehicle.getRegistrationNo());
		res.setVehicleBrand(vehicleModel.getBrand());
		res.setVehicleModel(vehicleModel.getModel());
		res.setInsuranceType(insurance.getType());
		res.setInsuranceDuration(insurance.getPlan());
		res.setInsuranceStartDate(insurance.getStartDate());
		res.setInsuranceEndDate(insurance.getStartDate()); ////NEED TO BE FIX
		res.setInsurancePremiumPaid(""+insurance.getFee());
		res.setMaxAmountInsured(""+(insurance.getFee()*50));
		
		
		return res;
	}

}
