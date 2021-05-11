package com.ss.training.w1.d1.a2;

import java.util.Random;
import java.util.Scanner;

public class W1D1Assignment2 {
	
	private static int number = 0;
	private static int grace = 10;
	private static Random r;
	private static Scanner s;

	public static void main(String[] args) {
		
		// first, initialize the Random and Scanner objects.
		r = new Random();
		s = new Scanner(System.in);
		
		// then, start the game
		startGame();
		
		s.close();
	}
	
	private static int getGuess(Scanner s) {
		String guessStr = s.nextLine();
		int guess = 1;
		try {
			guess = Integer.parseInt(guessStr);
		}catch(NumberFormatException nfe) {
			System.out.println("Invalid number, please enter a new number, between 1 and 100.");
			guess = getGuess(s);
		}
		
		if(guess <=0) {
			System.out.println("Number too small. Please enter a new number, between 1 and 100.");
			guess = getGuess(s);
		}
		
		if(guess > 100) {
			System.out.println("Number too large. Please enter a new number, between 1 and 100.");
			guess = getGuess(s);
		}
		
		return guess;
	}
	
	private static boolean checkGuess(int guess) {
		if(number >= guess-grace && number <= guess+grace) {
			return true;
		}
		return false;
	}
	
	private static void startGame() {
		number = r.nextInt(100)+1;
		int attempts = 0;
		int guess;
		while (attempts<5) {
			System.out.println("Please enter a number. Attempts remaining: " + (5-attempts));
			guess = getGuess(s);
			if(checkGuess(guess)) {
				System.out.println("Congratulations! You guessed the currect number within " + grace + " numbers. The correct number was " + number);
				if(guess == number && grace > 0) {
					System.out.println("You guessed the number exactly! Nice job!");
				}
				break;
			}else {
				if(attempts<4){
					System.out.println("Sorry. Please try again.");
				}else {
					System.out.println("Sorry, but the correct answer is " + number + ".");
				}
				attempts++;
			}
		}
	}

}
