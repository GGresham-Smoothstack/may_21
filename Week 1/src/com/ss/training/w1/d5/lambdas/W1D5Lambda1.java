package com.ss.training.w1.d5.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class W1D5Lambda1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sorter length = (i) -> {
			String[] output = new String[i.length];
			Arrays.sort(output, Comparator.comparing(String::length));
			return output;
		};
		
		Sorter reverseLength = (i) -> {
			String[] output = new String[i.length];
			Arrays.sort(output, Comparator.comparing(String::length).reversed());
			return output;
		};
		
		Sorter alpha = (i) -> {
			String[] output = new String[i.length];
			Arrays.sort(output, new AlphaCompare());
			return output;
		};
		
		Sorter e = (i) -> {
			String[] output = new String[i.length];
			Arrays.sort(output, new ECompare());
			return output;
		};

	}

}
