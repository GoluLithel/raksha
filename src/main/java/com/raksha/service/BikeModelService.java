package com.raksha.service;

import java.util.List;

import com.raksha.entity.BikeModel;

public interface BikeModelService {

	void addBikeModel(BikeModel bikemodel);

	BikeModel getById(int id);

	List<BikeModel> getAllBikeModel();

	void removeBikeModel(int id);

}
