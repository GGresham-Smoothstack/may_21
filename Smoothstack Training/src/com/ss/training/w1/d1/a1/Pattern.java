package com.ss.training.w1.d1.a1;

import java.util.ArrayList;

public class Pattern {
	
	// Here in the pattern class, we utilize StringBuilder objects rather than strings,
	// since we intend for the program to modify the input to flip the patterns.
	//
	// StringBuilders are designed for this purpose, and will prevent the additional memory
	// overhead of modifying String objects directly.
	//
	// We also make it private to prevent it being modified by other classes directly.
	private ArrayList<StringBuilder> data;
	
	public Pattern(ArrayList<String> input) {
		// create the list of StringBuilder objects from an input list of Strings
		data = new ArrayList<StringBuilder>();
		for(String s : input) {
			data.add(new StringBuilder(s));
		}
	}
	
	public void appendCharacter(char character, int line) {
		data.get(line).append(character);
	}
	
	public void flip() {
		// here, we utilize a for loop to iterate through the data backwards, store it
		// to a temporary value, and then use the temporary value to replace the initial data
		ArrayList<StringBuilder> temp = new ArrayList<StringBuilder>();
		for(int i=data.size()-1; i>=0; i--) {
			temp.add(data.get(i));
		}
		data = temp;
	}
	
	public void print() {
		// this method simply prints the contents of every StringBuilder in the list.
		// since we don't need the index for any operations here, we can just use this
		// simplified loop for easier readability
		for(StringBuilder s : data) {
			System.out.println(s);
		}
	}

}
