package com.ss.training.w1.d5.datetime;

import java.time.DayOfWeek;
import java.time.YearMonth;

public class W1D5Datetime6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		YearMonth yearMonthObject = YearMonth.of(2021, 5);
		for(int i=0; i<yearMonthObject.lengthOfMonth(); i++) {
			if(yearMonthObject.atDay(i+1).getDayOfWeek() == DayOfWeek.MONDAY) {
				System.out.println(yearMonthObject.getMonthValue() + "/" + (i+1) + "/" + yearMonthObject.getYear() + " is a Monday.");
			}
		}
	}

}
