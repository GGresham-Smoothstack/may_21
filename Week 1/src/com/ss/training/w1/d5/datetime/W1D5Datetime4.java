package com.ss.training.w1.d5.datetime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class W1D5Datetime4 {
	
	public static void main(String[] args) {
		Instant start = Instant.now();
		
		ZonedDateTime convert = start.atZone(ZoneId.systemDefault());
		
		Instant convert2 = convert.toInstant();
	}

}
