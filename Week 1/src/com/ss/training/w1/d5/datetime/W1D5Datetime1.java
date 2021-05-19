package com.ss.training.w1.d5.datetime;

import java.time.LocalDate;

public class W1D5Datetime1 {
	
	public static void main(String[] args) {
		
		W1D5Datetime1 assign = new W1D5Datetime1();
		LocalDate bdayExample = assign.birthday(1990, 1, 1);
		
	}
	
	public LocalDate birthday(int year, int month, int day) {
		return LocalDate.of(year, month, day);
	}

}
