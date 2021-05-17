package com.ss.training.w1.d5.lambdas;

import java.util.ArrayList;

public class W1D5Lambda3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringFilter filter = (i) -> {
			ArrayList<String> output = new ArrayList<String>();
			
			for(String string : i) {
				if(string.charAt(0) == 'a' && string.length() == 3) {
					output.add(string);
				}
			}
			
			return ((String[]) output.toArray());
		};
	}

}
