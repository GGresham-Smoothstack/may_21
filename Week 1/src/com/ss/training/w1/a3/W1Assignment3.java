package com.ss.training.w1.a3;

import java.util.Arrays;

public class W1Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		W1Assignment3 assignment = new W1Assignment3();
		
		int[] input1 = {1, 7, 11, 17, 211, 417};
		int[] input2 = {1, 7, 11, -17, -211, 417};
		
		int[] output1 = assignment.multiplyByTwo(input1);
		int[] output2 = assignment.multiplyByTwo(input2);
		
		System.out.println(Arrays.toString(output1));
		System.out.println(Arrays.toString(output2));
	}
	
	public int[] multiplyByTwo(int[] input){
		int[] output = new int[input.length];
		for(int i=0; i<input.length; i++) {
			output[i] = input[i] << 1;
		}
		return output;
	}

}
