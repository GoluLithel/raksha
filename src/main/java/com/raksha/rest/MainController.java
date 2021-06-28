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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raksha.entity.Bike;
import com.raksha.entity.BikeModel;
import com.raksha.entity.Car;
import com.raksha.entity.CarModel;
import com.raksha.entity.User;
import com.raksha.entity.UserLogin;
import com.raksha.mail.Mail;
import com.raksha.repo.AdminRepository;
import com.raksha.repo.UserRepository;
import com.raksha.response.OTPResponse;
import com.raksha.service.BikeModelService;
import com.raksha.service.BikeService;
import com.raksha.service.CarModelService;
import com.raksha.service.CarService;
import com.raksha.service.PDFDownloadService;
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
	
	@Autowired
	private UserRepository userRepo;
	
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private PDFDownloadService urlService;
	
//	@GetMapping(path = "/getOTP", produces = "application/json")
//	public List<String> getMessage(){
//		List<String> list = new ArrayList<String>();
//		list.add("Message Successfully Send");
//		String OTP = Mail.sendOTP("kuranjekar.sonali@gmail.com");
//		System.out.println(OTP);
//		return list;
//	}
	
	@PostMapping(path = "/getOTP", consumes = "application/json")
	public OTPResponse getOTP(@RequestBody UserLogin userLogin) {
		OTPResponse otpResponse  = new OTPResponse();
		if(userLogin.getUserType().equals("Admin")) {
			if(userLogin.getEmailId().equals("")) {
				if(adminRepo.mobileCount(userLogin.getMobileNo())>=1) {
					String email = adminRepo.getEmail(userLogin.getMobileNo());
					String password = adminRepo.getPassword(email);
					if(userLogin.getPassword().equals(password)) {
						return Mail.sendOTP(email);
					}else {
						otpResponse.setOTP("NO OTP");
						otpResponse.setStatus("INVALID PASSWORD");
						return otpResponse;
					}
				}else {
					otpResponse.setOTP("NO OTP");
					otpResponse.setStatus("INVALID MOBILE NO");
					return otpResponse;
				}
			}else {
				if(adminRepo.emailCount(userLogin.getEmailId())>=1) {
					String password = adminRepo.getPassword(userLogin.getEmailId());
					if(userLogin.getPassword().equals(password)) {
						return Mail.sendOTP(userLogin.getEmailId());
					}else {
						otpResponse.setOTP("NO OTP");
						otpResponse.setStatus("INVALID PASSWORD");
						return otpResponse;
					}
				}else {
					otpResponse.setOTP("NO OTP");
					otpResponse.setStatus("INVALID MAIL ADDRESS");
					return otpResponse;
				}
			}
		}else {
			if(userLogin.getEmailId().equals("")) {
				if(userRepo.mobileCount(userLogin.getMobileNo())>=1) {
					String email = userRepo.getEmail(userLogin.getMobileNo());
					return Mail.sendOTP(email);
				}else {
					otpResponse.setOTP("NO OTP");
					otpResponse.setStatus("INVALID MOBILE NO");
					return otpResponse;
				}
			}else {
				if(userRepo.emailCount(userLogin.getEmailId())>=1) {
					return Mail.sendOTP(userLogin.getEmailId());
				}else {
					otpResponse.setOTP("NO OTP");
					otpResponse.setStatus("INVALID MAIL ADDRESS");
					return otpResponse;
				}
			}
		}
	}
	
	
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
			map.put("modelTypeId",car.getVehicleModel()+"");
		}else if( bike != null) {
			map.put("vehicleType","Bike");
			map.put("modelTypeId",bike.getVehicleModel()+"");
		}else {
			map.put("vehicleType","Not Found");
			map.put("modelType","Not Applicable");
		}

		return map;
	}
	
	@GetMapping(path = "/sendMail/{uid}/{iid}", produces = "application/json")
	public String sendWelcomeMail(@PathVariable("uid") int uid, @PathVariable("iid") int iid) {
		User user = userService.getById(uid);
		String url = urlService.getPDFDownloadURL(iid);
		return Mail.sendWelcomeMail(user,url);
	}

}
