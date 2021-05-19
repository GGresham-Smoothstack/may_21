package com.ss.training.w1.d5.datetime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class W1D5Datetime4 {
	
	public static void main(String[] args) {
		
	}
	
	public Instant conversion(Instant start) {
		ZonedDateTime convert = start.atZone(ZoneId.systemDefault());
		
		return convert.toInstant();
	}

}
