package com.ss.training.w1.d1.a1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class W1D1Assignment1 {
	
	public static ArrayList<Pattern> parseInput(String input) {
		ArrayList<Pattern> patterns = new ArrayList<Pattern>();
		//First, we scan the input patterns from input.txt
		Scanner s = null;
		try {
			File in = new File(input);
			s = new Scanner(in);
			String str;
			ArrayList<String> strs = new ArrayList<String>();
			boolean started = false;
			// iterate through the input file
			while(s.hasNextLine()) {
				str = s.nextLine();
				// this program uses "Pattern" to signify the start of a pattern
				if(str.equals("Pattern")) {
					// first, make sure this isn't the first line of the input
					if(started == false) {
						started = true;
						// now, we check to see if there is data to process
					}else {
						// if we have data, create a new instance of the pattern class
						if(strs.size() > 0) {
							// create the pattern and clear the data for the next iteration
							patterns.add(createPattern(strs, true));
						}
					}
				}else {
					strs.add(str);
				}
			}
			// since we are now out of the loop, we can check if there's any remaining data
			// to turn into a pattern (from the final pattern stored in a file)
			patterns.add(createPattern(strs, true));
		}catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		}finally {
			if(s!=null) {
				s.close();
			}
		}
		return patterns;
	}
	
	// we split this off into its own method to avoid duplicate code
	// this way, we can create a pattern both inside and outside the parsing loop
	private static Pattern createPattern(ArrayList<String> input) {
		Pattern p = new Pattern(input);
		return p;
	}
	
	// same case here, an alternate version that allows specification as to whether
	// the input list should be cleared or not
	private static Pattern createPattern(ArrayList<String> input, boolean clearList) {
		Pattern p = createPattern(input);
		if(clearList) {
			input.clear();
		}
		return p;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Pattern> patterns = new ArrayList<Pattern>();
		
		// by setting up the input parsing this way, we can read patterns from
		// multiple input files if needed
		patterns.addAll(parseInput("assets/w1/d1/a1/input.txt"));
		
		
		// Now let's render the patterns to the console
		// First, let's iterate through the list
		for(int i=0; i<patterns.size(); i++) {
			// signify the pattern number, formatted as expected in the output
			System.out.println(((i*2)+1) + ")");
			patterns.get(i).print();
			
			// from here, the expected output of the inverse patterns can be achieved easily
			// by flipping the pattern and adding a period character to the first line
			// first, let's flip the pattern
			patterns.get(i).flip();
			// then append the period to what once was the final line
			patterns.get(i).appendCharacter('.', 0);
			
			// print the number of this new pattern
			System.out.println(((i*2)+2) + ")");
			// and print the flipped and appended pattern that was generated via the code
			patterns.get(i).print();
		}

	}

}
