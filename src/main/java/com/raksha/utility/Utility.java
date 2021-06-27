package com.raksha.utility;

import java.util.Calendar;

public class Utility {
	static public double calculateInsurancefee(int year, double price, String plan, String type) {

		int currentyear = Calendar.getInstance().get(Calendar.YEAR);
		int remainingyear = currentyear-year;
		double depriciatedprice = 0,typeprice=0,insuranceprice = 0,planprice,discount;
		double tempprice=price;
		if(remainingyear<=15) {
			
			for(int i = 1;i<=remainingyear;i++) {
				depriciatedprice=0.1*tempprice;
				tempprice=tempprice-depriciatedprice;
			}
			
			if(type.equalsIgnoreCase("Third Party")) {
				tempprice=0.02*depriciatedprice;
				typeprice=depriciatedprice+tempprice;		
			}
			else if(type.equalsIgnoreCase("Comprehensive")) {
				tempprice=0.035*depriciatedprice;
				typeprice=depriciatedprice+tempprice;
			}
			
			if(plan.equalsIgnoreCase("1 Year")) {
				planprice=0.02*typeprice;
				insuranceprice=typeprice+planprice;		
			}
			else if(plan.equalsIgnoreCase("2 Year")) {
				planprice=0.04*typeprice;
				insuranceprice=typeprice+planprice;		
				discount=0.1*insuranceprice;
				insuranceprice=insuranceprice-discount;
			}
			else if(plan.equalsIgnoreCase("3 Year")) {
				planprice=0.06*typeprice;
				insuranceprice=typeprice+planprice;	
				discount=0.3*insuranceprice;
				insuranceprice=insuranceprice-discount;
			}
			
		}
		else {
			System.out.println("Vehical Insurance not valid as its more than 15 year old!");
			return 0.0;
		}
		
		
		return insuranceprice;
	}
}
