package com.raksha.service;

import java.util.List;

import com.raksha.entity.CarModel;
import com.raksha.request.BikeModelRequest;
import com.raksha.request.CarModelRequest;

public interface CarModelService {

	void addCarModel(CarModel carmodel);

	CarModel getById(int id);

	List<CarModel> getAllCarModel();

	void removeCarModel(int id);
	
	List<CarModel> getModelByBrand(String brand);
	
	List<CarModel> getVariantFromBrandModel(String brand, String model);

	int getIdByDetails(BikeModelRequest carModelReq);

}
