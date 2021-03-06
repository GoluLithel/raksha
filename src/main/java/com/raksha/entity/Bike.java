package com.raksha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bike")
public class Bike implements Vehicle{
	
	@Id
	@Column(name = "regi_no")
	private String registrationNo;
	
	@Column(name = "bike_model_id")
	private int bikeModelId;

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public int getVehicleModel() {
		return bikeModelId;
	}

	public void setVehicleModel(int bikeModelId) {
		this.bikeModelId = bikeModelId;
	}
	
}
