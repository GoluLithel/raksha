package com.raksha.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.raksha.entity.Bike;
import com.raksha.entity.BikeModel;
import com.raksha.entity.Car;
import com.raksha.entity.CarModel;
import com.raksha.service.BikeModelService;
import com.raksha.service.BikeService;
import com.raksha.service.CarModelService;
import com.raksha.service.CarService;
import com.raksha.service.UserService;

@RestController
@CrossOrigin
public class MainController {
	
	@Autowired
	private BikeService bikeService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private CarModelService carModelservice;
	
	@Autowired
	private BikeModelService  bikeModelservice;
	
	
	@GetMapping(path = "/getBikeBrands", produces = "application/json")
	public List<String> getBikeBrands(){
		
		List<BikeModel> bikeModelList =  bikeModelservice.getAllBikeModel();
		Set<String> bikebrandSet = new TreeSet<String>();
		
		for(int i=0;i<bikeModelList.size();i++) {
			bikebrandSet.add(bikeModelList.get(i).getBrand());
		}
		
		List<String> bikebrandList = new ArrayList<String>();
		bikebrandList.addAll(bikebrandSet);
		
		return bikebrandList;
	}
	
	@GetMapping(path = "/getBikeModelFromBrand/{brand}", produces = "application/json")
	public List<String> getBikeModelFromBrand(@PathVariable("brand") String bikebrand){
		
		bikebrand=bikebrand.replace('_', ' ');
		
		List<BikeModel> bikeModelList =  bikeModelservice.getBikeModelByBrand(bikebrand);
		Set<String> bikemodelSet = new TreeSet<String>();
		for(int i=0;i<bikeModelList.size();i++) {
			bikemodelSet.add(bikeModelList.get(i).getModel());
		}
		
		List<String> bikemodelList = new ArrayList<String>();
		bikemodelList.addAll(bikemodelSet);
		
		return bikemodelList;
	}
	
	
	
	@GetMapping(path = "/getCarBrands", produces = "application/json")
	public List<String> getBrands(){
		
		List<CarModel> carModelList =  carModelservice.getAllCarModel();
		Set<String> brandSet = new TreeSet<String>();
		
		for(int i=0;i<carModelList.size();i++) {
			brandSet.add(carModelList.get(i).getBrand());
		}
		
		List<String> brandList = new ArrayList<String>();
		brandList.addAll(brandSet);
		
		return brandList;
	}
	
	@GetMapping(path = "/getCarModelFromBrand/{brand}", produces = "application/json")
	public List<String> getModelFromBrand(@PathVariable("brand") String brand){
		
		brand=brand.replace('_', ' ');
		
		List<CarModel> carModelList =  carModelservice.getModelByBrand(brand);
		Set<String> modelSet = new TreeSet<String>();
		for(int i=0;i<carModelList.size();i++) {
			modelSet.add(carModelList.get(i).getModel());
		}
		
		List<String> modelList = new ArrayList<String>();
		modelList.addAll(modelSet);
		
		return modelList;
	}
	

	@GetMapping(path = "/getCarVariantFromBrandModel/{brand}/{model}", produces = "application/json")
	public List<String> getVariantFromBrandModel(@PathVariable("brand") String brand, @PathVariable("model") String model){
		
		model=model.replace('_', ' ');
		
		List<CarModel> carModelList =  carModelservice.getVariantFromBrandModel(brand,model);
		Set<String> variantSet = new TreeSet<String>();
		for(int i=0;i<carModelList.size();i++) {
			variantSet.add(carModelList.get(i).getVariant());
		}
		
		List<String> variantList = new ArrayList<String>();
		variantList.addAll(variantSet);
		
		return variantList;
	}
	
	@GetMapping(path = "/getVehicleFromRcNo/{id}", produces = "application/json")
	public HashMap<String, String> getBike(@PathVariable("id") String id) {
		Bike bike;
		Car car;
		
		try {
			 bike = bikeService.getById(id);
		}catch(NoSuchElementException e) {
			bike = null;
		}
		
		try {
			car = carService.getById(id);
		}catch(NoSuchElementException e) {
			car = null;
		}
		
		HashMap<String, String> map = new HashMap<>();
		if(car != null) {
			map.put("vehicleType","Car");
			map.put("modelTypeId",car.getCarModel()+"");
		}else if( bike != null) {
			map.put("vehicleType","Bike");
			map.put("modelTypeId",bike.getBikeModel()+"");
		}else {
			map.put("vehicleType","Not Found");
			map.put("modelType","Not Applicable");
		}

		return map;
	}

}
