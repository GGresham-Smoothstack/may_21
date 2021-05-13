package com.ss.training.w1.d3.a3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class W1D3Assignment3 {

	public static void main(String[] args) {
		
		W1D3Assignment3 assign = new W1D3Assignment3();
		
		if(args.length > 1){
			assign.scanFileForCharacter(args[0], args[1].charAt(0));
		}else if(args.length == 1) {
			assign.scanFileForCharacter(args[0], 'e');
		}else {
			assign.scanFileForCharacter("assets/w1/d3/a3/input.txt", 'e');
		}

	}
	
	public void scanFileForCharacter(String filepath, char c){
		int instances = 0;
		char[] currentLine;
		File file = new File(filepath);
		Scanner s = null;
		try {
			s = new Scanner(file);
			while(s.hasNextLine()) {
				currentLine = s.nextLine().toCharArray();
				for(char ch : currentLine) {
					if(c == ch) {
						instances++;
					}
				}
			}
			s.close();
			System.out.println("The input file \"" + file + "\" has " + instances + " instances of the character \"" + c + "\".");
		} catch (FileNotFoundException e) {
			System.out.println("The input file \"" + file + "\" does not exist.");
		}
	}

}
