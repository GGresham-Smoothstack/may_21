package com.ss.training.w1.d5.lambdas;

import java.util.ArrayList;

public class W1D5Lambda3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		W1D5Lambda3 assign = new W1D5Lambda3();
		
		StringFilter filter = (i) -> {
			return assign.filter(i);
		};
	}
	
	public String[] filter(String[] i) {
		ArrayList<String> output = new ArrayList<String>();
		
		for(String string : i) {
			if(string.charAt(0) == 'a' && string.length() == 3) {
				output.add(string);
			}
		}
		
		String[] outputArray = new String[output.size()];
		
		for(int in=0; in<output.size(); in++) {
			outputArray[in] = output.get(in);
		}
		
		return outputArray;
	}

}
