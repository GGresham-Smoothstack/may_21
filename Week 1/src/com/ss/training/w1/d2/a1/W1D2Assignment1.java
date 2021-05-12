package com.ss.training.w1.d2.a1;

import java.util.ArrayList;

public class W1D2Assignment1 {
	
	private static final String ERR_NO_VALID_INPUTS = "No valid inputs were given. Please pass in at least one number as a command line argument.";
	
	public static void main(String[] args) {
		// Verify that the list of input args is not null or empty
		if(args!=null) {
			if(args.length > 0) {
				// If the list of args is valid, begin calculation
				W1D2Assignment1 calculator = new W1D2Assignment1();
				calculator.calculate(args);
				// Finally, close the application
				System.exit(0);
			}
		}
		// If the args are either null or empty, close the application
		System.out.println(ERR_NO_VALID_INPUTS);
		System.exit(0);
	}
	
	public void calculate(String[] args) {
		// Non-numbers can be input, despite not being able to add them
		// So we sort the numbers by either being valid or invalid
		
		ArrayList<Integer> validNumbers = new ArrayList<Integer>();
		ArrayList<String> invalidNumbers = new ArrayList<String>();
		
		
		for(String num: args) {
			try {
				Integer number = Integer.parseInt(num);
				validNumbers.add(number);
			}catch(NumberFormatException nfe) {
				invalidNumbers.add(num);
			}
		}
		
		// Next, we create String Builders for our output messages.
		
		StringBuilder sumMessage = new StringBuilder();
		StringBuilder invalidNotif = new StringBuilder("Invalid Inputs: ");
		
		// If we have any valid numbers, begin adding.
		
		if(validNumbers.size()>0) {
			Integer sum = 0;
			
			for(int i=0; i<validNumbers.size(); i++) {
				sum = sum + validNumbers.get(i);
				sumMessage.append(validNumbers.get(i));
				if(i<validNumbers.size()-1) {
					sumMessage.append(" + ");
				}
			}
			
			sumMessage.append(" = " + sum);
			
		}else {
			// Otherwise, we return the same message as before, 
			// about no valid inputs being given.
			
			sumMessage.append(ERR_NO_VALID_INPUTS);
			
		}
		
		// Next, we process the invalid inputs, so the user knows which inputs were invalid.
		
		for(int i=0; i<invalidNumbers.size(); i++) {
			invalidNotif.append(invalidNumbers.get(i));
			if(i<invalidNumbers.size()-1) {
				invalidNotif.append(" , ");
			}
		}
		
		// Then we print out the sum, along with the inputs that were added together
		
		System.out.println(sumMessage);
		
		// Finally, if there were any invalid inputs, we print them to the console as well
		
		if(invalidNumbers.size() > 0) {
			System.out.println(invalidNotif);
		}
	}

}
