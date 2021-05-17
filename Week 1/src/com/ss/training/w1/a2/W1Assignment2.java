package com.ss.training.w1.a2;

import java.util.Arrays;

public class W1Assignment2 {
	
	public static void main(String[] args) {
		W1Assignment2 assignment = new W1Assignment2();
		
		int[] input1 = {1, 7, 11, 17, 211, 417};
		int[] input2 = {1, 7, 11, -17, -211, 417};
		
		int[] output1 = assignment.rightmostDigits(input1);
		int[] output2 = assignment.rightmostDigits(input2);
		
		System.out.println(Arrays.toString(output1));
		System.out.println(Arrays.toString(output2));
	}
	
	public int[] rightmostDigits(int[] input) {
		int[] output = new int[input.length];
		int removeFromArray = 0;
		for(int i=0; i<input.length; i++) {
			if(input[i]<0) {
				removeFromArray++;
				continue;
			}else if(input[i]<=9) {
				output[i-removeFromArray] = input[i];
				continue;
			}
			output[i-removeFromArray] = input[i]%10;
		}
		if(removeFromArray>0) {
			int[] newOutput = new int[output.length-removeFromArray];
			for(int i=0; i<newOutput.length; i++) {
				newOutput[i] = output[i];
			}
			return newOutput;
		}
		
		
		return output;
	}

}
