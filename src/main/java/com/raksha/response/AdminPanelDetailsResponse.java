package com.raksha.response;

public class AdminPanelDetailsResponse {
	
	private long userCount;
	private long thirdPartyCount;
	private long comprehensiveCount;
	private long visitorCount;
	private long bikeInsuranceCount;
	private long carInsuranceCount;	
	
	public AdminPanelDetailsResponse() {
		super();
		this.userCount = 0;
		this.thirdPartyCount = 0;
		this.comprehensiveCount = 0;
		this.visitorCount = 0;
		this.bikeInsuranceCount = 0;
		this.carInsuranceCount = 0;
	}
	
	public long getUserCount() {
		return userCount;
	}
	
	public void setUserCount(long l) {
		this.userCount = l;
	}
	
	public long getThirdPartyCount() {
		return thirdPartyCount;
	}
	
	public void setThirdPartyCount(long l) {
		this.thirdPartyCount = l;
	}
	
	public long getComprehensiveCount() {
		return comprehensiveCount;
	}
	
	public void setComprehensiveCount(long l) {
		this.comprehensiveCount = l;
	}
	
	public long getVisitorCount() {
		return visitorCount;
	}
	
	public void setVisitorCount(long visitorCount) {
		this.visitorCount = visitorCount;
	}
	
	public long getBikeInsuranceCount() {
		return bikeInsuranceCount;
	}
	
	public void setBikeInsuranceCount(long bikeInsuranceCount) {
		this.bikeInsuranceCount = bikeInsuranceCount;
	}
	
	public long getCarInsuranceCount() {
		return carInsuranceCount;
	}
	
	public void setCarInsuranceCount(long carInsuranceCount) {
		this.carInsuranceCount = carInsuranceCount;
	}
	
}
