package com.ss.training.w1.d5.lambdas;

import java.util.Arrays;
import java.util.Comparator;

public class W1D5Lambda2 {

	public static void main(String[] args) {
		StringAssemble assemble = (i) -> {
			String[] output = new String[i.length];
			for(int num=0; num < i.length; num++) {
				if(i[num] % 2 == 0) {
					output[num] = "e"+i[num];
				}else {
					output[num] = "o"+i[num];
				}
			}
			return output;
		};

	}

}
