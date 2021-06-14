package com.raksha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car{
	
	@Id
	@Column(name = "regi_no")
	private String registrationNo;
	
	@Column(name = "car_model_id")
	private int carModelId;

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public int getCarModel() {
		return carModelId;
	}

	public void setCarModel(int carModelId) {
		this.carModelId = carModelId;
	}
	
	
}
