package com.ss.training.w1.d5.datetime;

import java.time.DayOfWeek;
import java.time.YearMonth;
import java.util.ArrayList;

public class W1D5Datetime6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		W1D5Datetime6 assign = new W1D5Datetime6();
		YearMonth yearMonthObject = YearMonth.of(2021, 5);
		int[] mondays = assign.getMondays(yearMonthObject);
		for(int i=0; i<mondays.length; i++) {
			System.out.println(yearMonthObject.getMonthValue() + "/" + mondays[i] + "/" + yearMonthObject.getYear() + " is a Monday.");
		}
	}
	
	public int[] getMondays(YearMonth input) {
		ArrayList<Integer> mondays = new ArrayList<Integer>();
		for(int i=0; i<input.lengthOfMonth(); i++) {
			if(input.atDay(i+1).getDayOfWeek() == DayOfWeek.MONDAY) {
				mondays.add(i+1);
				//System.out.println(yearMonthObject.getMonthValue() + "/" + (i+1) + "/" + yearMonthObject.getYear() + " is a Monday.");
			}
		}
		
		int[] mondaysArray = new int[mondays.size()];
		for(int i=0; i<mondays.size(); i++) {
			mondaysArray[i] = mondays.get(i);
		}
		
		return mondaysArray;
	}

}
