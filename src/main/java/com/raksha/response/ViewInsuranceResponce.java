package com.raksha.response;

public class ViewInsuranceResponce {

	private int policyNumber;
	private String userFname;
	private String userMname;
	private String userLname;
	private String userEmail;
	private String userPhone;
	private String userPhotoIdType;
	private String userPhotoIdNumber;
	private String vehicleType;
	private String vehicleRegistrationNumber;
	private String vehicleBrand;
	private String vehicleModel;
	private String insuranceType;
	private String insuranceDuration;
	private String insuranceStartDate;
	private String insuranceEndDate;
	private String insurancePremiumPaid;
	private String maxAmountInsured;
	
	public ViewInsuranceResponce() {
		
	}
	
	public ViewInsuranceResponce(int policyNumber) {
		super();
		this.policyNumber = policyNumber;
	}

	public int getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPhotoIdType() {
		return userPhotoIdType;
	}

	public void setUserPhotoIdType(String userPhotoIdType) {
		this.userPhotoIdType = userPhotoIdType;
	}

	public String getUserPhotoIdNumber() {
		return userPhotoIdNumber;
	}

	public void setUserPhotoIdNumber(String userPhotoIdNumber) {
		this.userPhotoIdNumber = userPhotoIdNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleRegistrationNumber() {
		return vehicleRegistrationNumber;
	}

	public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
		this.vehicleRegistrationNumber = vehicleRegistrationNumber;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getInsuranceDuration() {
		return insuranceDuration;
	}

	public void setInsuranceDuration(String insuranceDuration) {
		this.insuranceDuration = insuranceDuration;
	}

	public String getInsuranceStartDate() {
		return insuranceStartDate;
	}

	public void setInsuranceStartDate(String insuranceStartDate) {
		this.insuranceStartDate = insuranceStartDate;
	}

	public String getInsuranceEndDate() {
		return insuranceEndDate;
	}

	public void setInsuranceEndDate(String insuranceEndDate) {
		this.insuranceEndDate = insuranceEndDate;
	}

	public String getInsurancePremiumPaid() {
		return insurancePremiumPaid;
	}

	public void setInsurancePremiumPaid(String insurancePremiumPaid) {
		this.insurancePremiumPaid = insurancePremiumPaid;
	}

	public String getMaxAmountInsured() {
		return maxAmountInsured;
	}

	public void setMaxAmountInsured(String maxAmountInsured) {
		this.maxAmountInsured = maxAmountInsured;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getUserFname() {
		return userFname;
	}

	public void setUserFname(String userFname) {
		this.userFname = userFname;
	}

	public String getUserMname() {
		return userMname;
	}

	public void setUserMname(String userMname) {
		this.userMname = userMname;
	}

	public String getUserLname() {
		return userLname;
	}

	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}
	
	
	
}
