package com.ss.training.w1.d5.datetime;

import java.time.YearMonth;

public class W1D5Datetime5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		YearMonth yearMonthObject;
		//int daysInMonth = yearMonthObject.lengthOfMonth();
		for(int i=0; i<12; i++) {
			yearMonthObject = YearMonth.of(2021, i+1);
			System.out.println("Length of Month " + (i+1) + " in 2021: " + yearMonthObject.lengthOfMonth());
		}
	}

}
