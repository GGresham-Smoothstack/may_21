package com.ss.training.w1.d5.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class W1D5Datetime7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		W1D5Datetime7 assign = new W1D5Datetime7();
		
		System.out.println(assign.onFridayTheThirteenth(LocalDate.now()));

	}
	
	public boolean onFridayTheThirteenth(LocalDate input) {
		
		if(input.getDayOfWeek() == DayOfWeek.FRIDAY && input.getDayOfMonth() == 13) {
			return true;
		}
		
		return false;
	}

}
