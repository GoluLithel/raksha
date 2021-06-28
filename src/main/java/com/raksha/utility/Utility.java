package com.raksha.utility;

import java.util.Calendar;

public class Utility {

	final static double DEPRI_RATE = 0.1;
	final static double THIRD_RATE = 0.02;
	final static double COMPRE_RATE = 0.035;
	final static double DIS_2YR = 0.1;
	final static double DIS_3YR = 0.25;

	static public double calculateInsurancefee(int year, double price, String plan, String type) {

		double premium = 0;
		double depriciatedprice = 0;

		depriciatedprice = getDepriciatedPrice(price,year);

		///Insurance Type
		if (type.equalsIgnoreCase("Third Party")) {
			premium = THIRD_RATE * depriciatedprice;
		} else {
			premium = COMPRE_RATE * depriciatedprice;
		}


		//Planes
		if (plan.equalsIgnoreCase("2 Year")) {
			premium *= 2;
			premium = premium * (1-DIS_2YR);
		} else if (plan.equalsIgnoreCase("3 Year")) {
			premium *= 3;
			premium = premium * (1-DIS_3YR);
		}

		return (int) Math.round(premium);
	}
	private static double getDepriciatedPrice(double price, int year) {

		int remainingYear = Calendar.getInstance().get(Calendar.YEAR) - year;

		double depriciatedprice = price;

		for (int i = 0; i <= remainingYear; i++) {
			depriciatedprice = depriciatedprice * (1-DEPRI_RATE);
		}

		return depriciatedprice;
	}
}
