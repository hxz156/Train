package com.mercury.java_core.collection;

import java.util.Comparator;

// define a custom comparing logic
// big int comes first, small int goes last
// 6 4 1
public class DesendingComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		
		return o2- o1;
		
	}

}


