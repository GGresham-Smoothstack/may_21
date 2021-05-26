package com.ss.utopia.jdbc;

public abstract class Menu {
	
	public int validateIntegerInput(String input, int minValue, int maxValue) {
		try{
			int value = Integer.parseInt(input);
			if(value >= minValue && value <= maxValue && value >= 0) {
				return value;
			}else {
				return -1;
			}
		}catch(NumberFormatException nfe) {
			return -1;
		}
	}

}
