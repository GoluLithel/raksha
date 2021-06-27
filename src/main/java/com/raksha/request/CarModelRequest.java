package com.raksha.request;

public class CarModelRequest {

	private String Brand;
	private String Model;
	private int Year;
	private String fuelType;
	private String variant;
	
	public String getBrand() {
		return Brand;
	}
	
	public void setBrand(String brand) {
		Brand = brand;
	}
	
	public String getModel() {
		return Model;
	}
	
	public void setModel(String model) {
		Model = model;
	}
	
	public int getYear() {
		return Year;
	}
	
	public void setYear(int year) {
		Year = year;
	}
	
	public String getFuelType() {
		return fuelType;
	}
	
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	
	public String getVariant() {
		return variant;
	}
	
	public void setVariant(String variant) {
		this.variant = variant;
	}
	
}
