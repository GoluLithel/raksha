package com.raksha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raksha.entity.BikeModel;
import com.raksha.entity.Insurance;
import com.raksha.entity.VehicleModel;
import com.raksha.repo.BikeModelRepository;
import com.raksha.repo.CarModelRepository;
import com.raksha.repo.InsuranceRepository;
import com.raksha.response.InsurancesPlanResponse;
import com.raksha.utility.Utility;

@Service
public class InsuranceServiceImpl implements InsuranceService {
	
	@Autowired
	private InsuranceRepository repo;
	
	@Autowired
	private CarModelRepository carRepo;
	
	@Autowired
	private BikeModelRepository bikeRepo;
	
	@Override
	public void addInsurance(Insurance insurance) {
		repo.save(insurance);
	}

	@Override
	public Insurance getById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Insurance> getAllInsurance() {
		return repo.findAll();
	}

	@Override
	public void removeInsurance(int id) {
		repo.deleteById(id);;
	}

	@Override
	public List<Insurance> getInsurancesByUser(int userId) {
		// TODO Auto-generated method stub
		return repo.findInsuranceByUser(userId);
	}

	@Override
	public long getThirdPartyCount() {
		// TODO Auto-generated method stub
		return repo.getInsuranceTypeCount("Third Party");
	}

	@Override
	public long getCoprehensiveCount() {
		// TODO Auto-generated method stub
		return repo.getInsuranceTypeCount("Comprehensive");
	}

	@Override
	public long getBikeInsuraceCount() {
		// TODO Auto-generated method stub
		return repo.getInsuranceVehicleTypeCount("Bike");
	}

	@Override
	public long getCarInsuranceCount() {
		// TODO Auto-generated method stub
		return repo.getInsuranceVehicleTypeCount("Bike");
	}

	@Override
	public InsurancesPlanResponse getInsurancesPlanResponse(String vehicleType, int id) {
		// TODO Auto-generated method stub
		InsurancesPlanResponse res = new InsurancesPlanResponse();
		VehicleModel vehicleModel = null;
		if(vehicleType.equalsIgnoreCase("bike")) {
			vehicleModel = bikeRepo.getById(id);
		}else {
			vehicleModel = carRepo.getById(id);
		}
		
		res.setCompreYear1(Utility.calculateInsurancefee(vehicleModel.getYear(), vehicleModel.getPrice(), "1 Year", "Comprehensive"));
		res.setCompreYear2(Utility.calculateInsurancefee(vehicleModel.getYear(), vehicleModel.getPrice(), "2 Year", "Comprehensive"));
		res.setCompreYear3(Utility.calculateInsurancefee(vehicleModel.getYear(), vehicleModel.getPrice(), "3 Year", "Comprehensive"));
		res.setThirdYear1(Utility.calculateInsurancefee(vehicleModel.getYear(), vehicleModel.getPrice(), "1 Year", "Third Party"));
		res.setThirdYear2(Utility.calculateInsurancefee(vehicleModel.getYear(), vehicleModel.getPrice(), "2 Year", "Third Party"));
		res.setThirdYear3(Utility.calculateInsurancefee(vehicleModel.getYear(), vehicleModel.getPrice(), "3 Year", "Third Party"));
		return res;
	}

}
