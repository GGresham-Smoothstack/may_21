package com.ss.training.w1.d5.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class W1D5Datetime2 {
	
	public static void main(String[] args) {
		LocalDate startDate = LocalDate.now();
		LocalDate lastThursday = startDate.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY));
	}

}
