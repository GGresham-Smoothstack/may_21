package com.ss.training.w1.a5;

import java.util.ArrayList;
import java.util.Arrays;

public class W1Assignment5 {
	
	public static void main(String[] args) {
		
		W1Assignment5 assign = new W1Assignment5();
		
		int[] input1 = {2, 4, 8};
		int[] input2 = {1, 2, 4, 8, 1};
		int[] input3 = {2, 4, 4, 8};
		
		System.out.println("Numbers to Add: " + Arrays.toString(input1) + " Desired Sum: 10 CanAdd: " + assign.checkNumbers(0, input1, 10));
		System.out.println("Numbers to Add: " + Arrays.toString(input2) + " Desired Sum: 14 CanAdd: " + assign.checkNumbers(0, input2, 14));
		System.out.println("Numbers to Add: " + Arrays.toString(input3) + " Desired Sum: 14 CanAdd: " + assign.checkNumbers(0, input3, 14));
	}
	
	public boolean checkNumbers(int offset, int[] numsToSum, int desiredValue) {
		boolean result = false;
		int sum = 0;
		int numIdentical=1;
		int nextNumIdentical=1;
		int i = offset;
		int[] newNums;
		while(i<numsToSum.length) {
			numIdentical = getExtent(numsToSum[i], 1, i, numsToSum);
			sum = sum + numsToSum[i] * numIdentical;
			i+=numIdentical;
			if(sum == desiredValue) {
				result = true;
				break;
			}
		}
		if(sum == desiredValue) {
			result = true;
		}else if(offset+numIdentical<numsToSum.length) {
			
			nextNumIdentical = getExtent(numsToSum[offset+numIdentical], 1, offset+numIdentical, numsToSum);
			newNums = new int[numsToSum.length-nextNumIdentical-offset];
			//newNums[0] = numsToSum[0];
			for(int j=offset; j<newNums.length; j++) {
				if(j>=numIdentical) {
					newNums[j] = numsToSum[j+nextNumIdentical];
				}else {
					newNums[j] = numsToSum[j];
				}
			}
			if(checkNumbers(0, newNums, desiredValue)) {
				result = true;
			}else {
				return checkNumbers(offset+numIdentical, numsToSum, desiredValue);
			}
		}else {
			return false;
		}
//			if(numsToSum.length-(offset+numIdentical)<=2) {
//				result = false;
//			}else {
//				if(offset+numIdentical >= numsToSum.length) {
//					return false;
//				}
//				nextNumIdentical = getExtent(numsToSum[offset+numIdentical], 1, offset+numIdentical, numsToSum);
//				newNums = new int[numsToSum.length-nextNumIdentical];
//				System.out.println("Instances of " + numsToSum[offset+numIdentical] + ": " + nextNumIdentical);
//				newNums[0] = numsToSum[0];
//				for(int j=1+nextNumIdentical; j<numsToSum.length; j++) {
//					newNums[j-nextNumIdentical] = numsToSum[j];
//				}
//				System.out.println(Arrays.toString(newNums));
//				if(checkNumbers(0, newNums, desiredValue)) {
//					result = true;
//				}else {
//					return checkNumbers(offset+numIdentical, numsToSum, desiredValue);
//				}
//			}
//		}
		return result;
	}
	
	public boolean checkNumbers(int[] numsToSum, int desiredValue) {
		int workOffset=0;
		int loopOffset=0;
		boolean running = true;
		boolean result = false;
		int workSum = 0;
		int workInt = 0;
		while(running) {
			if(loopOffset>=numsToSum.length) {
				running=false;
				break;
			}
			workInt = getExtent(numsToSum[loopOffset], 1, loopOffset, numsToSum);
			workSum = numsToSum[loopOffset] * workInt;
			workOffset = loopOffset + workInt;
			if(workSum == desiredValue) {
				result = true;
				running=false;
				break;
			}
			if(workSum > desiredValue) {
				loopOffset++;
				continue;
			}
		}
		return result;
	}
	
	public int getExtent(int desiredValue, int numFound, int offset, int[] nums) {
		int result = numFound;
		if(offset+1 >= nums.length) {
			return result;
		}
		if(nums[offset+1] != desiredValue) {
			return result;
		}
		result = getExtent(desiredValue, result+1, offset+1, nums);
		return result;
	}

}
