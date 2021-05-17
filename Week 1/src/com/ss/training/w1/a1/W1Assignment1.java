package com.ss.training.w1.a1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.ss.training.w1.a1.interfaces.IsOdd;
import com.ss.training.w1.a1.interfaces.IsPalindrome;
import com.ss.training.w1.a1.interfaces.IsPrime;

public class W1Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IsOdd isOdd = (i) -> (i%2==1);
		
		IsPrime isPrime = (i) -> {
			if(i<2) {
				return false;
			}
			boolean ret = true;
			for(int j=2; j<=i/2; j++) {
				if (i % j == 0) {
					ret = false;
			        break;
			      }
			}
			return ret;
		};
		
		IsPalindrome isPalindrome = (i) -> {
			if(i<10) {
				return false;
			}
			
			String s = Integer.toString(i);
			boolean result = true;
			
			for(int j=0; j<s.length()/2; j++) {
				if(s.charAt(j) != s.charAt((s.length()-j)-1)) {
					result = false;
					break;
				}
			}
			return result;
		};
		
		Scanner s = null;
		try {
			File in = new File("assets/w1/input.txt");
			s = new Scanner(in);
			int numSets = 0;
			int setsChecked = 0;
			String nextLine;
			numSets = Integer.parseInt(s.nextLine());
			String[] numSet;
			int conv;
			while(s.hasNextLine()) {
				if(setsChecked < numSets) {
					System.out.println("Test Case " + (setsChecked+1) + ":");
					nextLine = s.nextLine();
					numSet = nextLine.split(" ");
					for(String num : numSet) {
						conv = Integer.parseInt(num);
						if(isPalindrome.isPalindrome(conv)) {
							System.out.println("PALINDROME");
							continue;
						}else if(isPrime.isPrime(conv)) {
							System.out.println("PRIME");
							continue;
						}else if(isOdd.isOdd(conv)) {
							System.out.println("ODD");
							continue;
						}
						System.out.println("EVEN");
					}
					setsChecked++;
				}else {
					break;
				}
			}
		}catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		}catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}finally {
			if(s!=null) {
				s.close();
			}
		}
	}

}
