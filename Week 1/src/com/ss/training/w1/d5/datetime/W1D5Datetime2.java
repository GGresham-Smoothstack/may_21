package com.ss.training.w1.d5.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class W1D5Datetime2 {
	
	public static void main(String[] args) {
		W1D5Datetime2 assign = new W1D5Datetime2();
		LocalDate startDate = LocalDate.now();
		LocalDate lastThursday = assign.lastThursday(startDate);
	}
	
	public LocalDate lastThursday(LocalDate input) {
		return input.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY));
	}

}
