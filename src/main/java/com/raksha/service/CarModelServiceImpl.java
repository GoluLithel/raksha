package com.raksha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raksha.entity.CarModel;
import com.raksha.repo.CarModelRepository;
import com.raksha.request.CarModelRequest;

@Service
public class CarModelServiceImpl implements CarModelService{
	
	@Autowired
	private CarModelRepository repo;
	
	@Override
	public void addCarModel(CarModel carmodel) {
		repo.save(carmodel);
	}

	@Override
	public CarModel getById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public List<CarModel> getAllCarModel() {
		return repo.findAll();
	}

	@Override
	public void removeCarModel(int id) {
		repo.deleteById(id);;
	}

	@Override
	public List<CarModel> getModelByBrand(String brand) {
		return repo.findModelByBrand(brand);
	}

	@Override
	public List<CarModel> getVariantFromBrandModel(String brand, String model) {
		// TODO Auto-generated method stub
		return repo.findVariantByBrandModel(brand, model);
	}

	@Override
	public int getIdByDetails(CarModelRequest carModelReq) {
		// TODO Auto-generated method stub
		return repo.findIdByDetails(carModelReq.getBrand(),
				carModelReq.getModel(),
				carModelReq.getVariant(),
				carModelReq.getFuelType(),
				carModelReq.getYear());
	}
	
	

}
