package com.ss.training.w1.d5.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class W1D5Lambda1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		W1D5Lambda1 assignment = new W1D5Lambda1();
		
		Sorter length = (i) -> {
			return assignment.length(i);
		};
		
		Sorter reverseLength = (i) -> {
			return assignment.reverseLength(i);
		};
		
		Sorter alpha = (i) -> {
			return assignment.alpha(i);
		};
		
		Sorter e = (i) -> {
			return assignment.e(i);
		};

	}
	
	public String[] length(String[] i) {
		//String[] output = new String[i.length];
		Arrays.sort(i, Comparator.comparing(String::length));
		//return output;
		return i;
	}
	
	public String[] reverseLength(String[] i) {
		Arrays.sort(i, Comparator.comparing(String::length).reversed());
		return i;
	}
	
	public String[] alpha(String[] i) {
		Arrays.sort(i, new AlphaCompare());
		return i;
	}
	
	public String[] e(String[] i) {
		Arrays.sort(i, new ECompare());
		return i;
	}

}
