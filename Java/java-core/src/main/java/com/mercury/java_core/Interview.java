package com.mercury.java_core;

import java.util.HashMap;
import java.util.Map;

//Find the index and length of longest tuple(same character). 
//Example String str ="aaaaaaabbbbbcc"
// a, 0, 7
public class Interview {

	public static void main(String[] args) {
		String str ="aaaaaaabbbbbcc11111111";
		int max = 0;
		int index = 0;
		char theChar = 'a';
		Map<Character, Integer> map = new HashMap<>();
		for(char c: str.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		System.out.println(map);
		for(Map.Entry<Character, Integer> entry: map.entrySet()){
			if(entry.getValue() > max) {
				max = entry.getValue();
				theChar = entry.getKey();
			}
		}
		System.out.println("max is: " + max);
		System.out.println("char is: " + theChar);
//		for(Map.Entry<Character, Integer> entry: map.entrySet()){
//			if(entry.getValue() == max) {
//				theChar = entry.getKey();
//			}
//		}
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == theChar){
				index = i;
				break;
			}
		}
		System.out.println("index is: " + index);
		System.out.println(theChar + "," + index + "," + max);

	}

}
