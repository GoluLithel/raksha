package com.raksha.service;

import java.util.List;

import com.raksha.entity.CarModel;

public interface CarModelService {

	void addCarModel(CarModel carmodel);

	CarModel getById(int id);

	List<CarModel> getAllCarModel();

	void removeCarModel(int id);
	
	List<CarModel> getModelByBrand(String brand);
	
	List<CarModel> getVariantFromBrandModel(String brand, String model);

}
