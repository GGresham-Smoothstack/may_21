package com.ss.training.w1.d5.lambdas;

import java.util.Comparator;

public class AlphaCompare implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		if(o1.charAt(0) < o2.charAt(0)) {
			return -1;
		}else if(o1.charAt(0) > o2.charAt(0)) {
			return 1;
		}
		return 0;
	}

}
