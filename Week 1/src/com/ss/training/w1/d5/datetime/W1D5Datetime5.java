package com.ss.training.w1.d5.datetime;

import java.time.YearMonth;

public class W1D5Datetime5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		W1D5Datetime5 assign = new W1D5Datetime5();
		//int daysInMonth = yearMonthObject.lengthOfMonth();
		YearMonth[] months = assign.getMonths(2021);
		for(int i=0; i<12; i++) {
			System.out.println("Length of Month " + (i+1) + " in 2021: " + months[i].lengthOfMonth());
		}
	}
	
	public YearMonth[] getMonths(int year) {
		YearMonth[] months = new YearMonth[12];
		
		for(int i=0; i<12; i++) {
			months[i] = YearMonth.of(year, i+1);
		}
		
		return months;
	}

}
