package com.ss.training.w1.d2.a2;

import java.util.Arrays;
import java.util.Random;

public class W1D2Assignment2 {
	
	private Random random;
	private int largestNumber, largestNumberX, largestNumberY;
	
	public W1D2Assignment2() {
		random = new Random();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		W1D2Assignment2 assignment = new W1D2Assignment2();
		
		int[][] array = assignment.checkArgs(args);
		
		
		System.out.println("Largest Number is " + assignment.getLargestNumber() + " at position " + assignment.getLargestNumberX() + ", " + assignment.getLargestNumberY());
		
		System.out.println(Arrays.deepToString(array));

	}
	
	private int calculateLargerValue(int largestValue, int newValue, int x, int y) {
		if(largestValue >= newValue) {
			return largestValue;
		}
		largestNumberX = x;
		largestNumberY = y;
		return newValue;
	}
	
	private int[][] checkArgs(String[] args) {
		int[][] numbers = new int[0][0];
		if(args == null) {
			numbers = generateArray();
		}else {
			if(args.length >= 4){
				if(args[0].equals("-generate") || args[0].equals("-gen") || args[0].equals("-g")) {
					try {
						numbers = generateArray(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
					}catch(NumberFormatException nfe) {
						invalidSyntax(args[0] + " \"size of first dimension\" \"size of second dimension\" \"maximum value to generate\"");
					}
				}else {
					numbers = generateArray();
				}
			}else {
				numbers = generateArray();
			}
		}
		return numbers;
	}
	
	private int[][] generateArray(){
		// If no bounds are set, we create a 2D array of a random size, 
		// between 1 and 5 in each dimension, and with a maximum value of 100
		return generateArray(random.nextInt(5)+1, random.nextInt(5)+1, 100);
	}
	
	private int[][] generateArray(int sizeX, int sizeY, int maxValue) {
		// First, we create a 2D array of the specified size
		int[][] numbers = new int[sizeX][sizeY];

		// Next we populate the 2D array with random numbers between 1 and 100
		// To save cycles, we also calculate the largest generated number at this time
		// First, we set the largest number to the lowest possible value

		largestNumber = Integer.MIN_VALUE;

		for(int x=0; x<numbers.length; x++) {
			for(int y=0; y<numbers[x].length; y++) {
				numbers[x][y] = random.nextInt(maxValue)+1;
				largestNumber = calculateLargerValue(largestNumber, numbers[x][y], x, y);
			}
		}
		return numbers;
	}
	
	public void invalidSyntax(String expected) {
		System.out.println("Invalid parameters. Expected syntax is as follows: " + expected);
		System.exit(0);
	}
	
	public int getLargestNumber() {
		return largestNumber;
	}
	
	public int getLargestNumberX() {
		return largestNumberX;
	}
	
	public int getLargestNumberY() {
		return largestNumberY;
	}

}
