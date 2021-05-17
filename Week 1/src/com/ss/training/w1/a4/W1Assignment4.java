package com.ss.training.w1.a4;

import java.util.Arrays;

public class W1Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		W1Assignment4 assignment = new W1Assignment4();
		
		String[] input = {"saxophone", "xylophone", "fax", "xx" + "xax", "a", "the character does not appear here", "oh no! a wild x has appeared!"};
		
		String[] result = assignment.removeX(input);
		
		System.out.println(Arrays.toString(result));

	}
	
	public String[] removeX(String[] input) {
		String[] output = new String[input.length];
		StringBuilder sb = new StringBuilder();
		int j;
		for(int i=0; i<input.length; i++) {
			sb.append(input[i]);
			j=0;
			while(j<sb.length()) {
				if(sb.charAt(j) == 'x') {
					sb.deleteCharAt(j);
					continue;
				}
				j++;
			}
			output[i] = sb.toString();
			sb.delete(0, sb.length());
		}
		
		return output;
	}

}
