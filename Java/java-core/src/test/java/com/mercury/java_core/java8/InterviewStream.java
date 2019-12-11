package com.mercury.java_core.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterviewStream {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("a", "ab", "c", "ad");
		List<String> result = list.stream()
								.filter(str -> str.charAt(0) == 'a')
								.collect(Collectors.toList());
		System.out.println(result);
		
		List<Integer> intList = Arrays.asList(1,3,5,2,1,6,7,8);
		Stream<Integer> intStream = intList.stream();
		List<Integer> intResult = intStream
									.filter(num -> num > 5)
									.collect(Collectors.toList());
		System.out.println(intResult);			
	}
}






