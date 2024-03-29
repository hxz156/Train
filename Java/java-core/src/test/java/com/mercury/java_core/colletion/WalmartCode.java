package com.mercury.java_core.colletion;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class WalmartCode {

	public static void main(String[] args) {
		System.out.println(output("dddaaacccgggg"));
	}
	public static String output(String str) {
		// create comparator
		Comparator<Map.Entry<Character, Integer>> myComparator = (e1, e2) -> {
			if(e1.getValue() == e2.getValue()){
				return e1.getKey() - e2.getKey();
			} else {
				return e2.getValue() - e1.getValue();
			}
		};
		
		Comparator<Character> fakeCom = (e1, e2)-> {
			return e2- e1;
		};
				
		Map<Character, Integer> treeMap = new TreeMap<>();
		StringBuilder sb = new StringBuilder();
		
		// Create treeMap, put value into it
		for (char c: str.toCharArray()) {
			treeMap.put(c, treeMap.getOrDefault(c, 0) + 1);
		}
		
		// Because Map can not compare value, we use Set to compare, put entry into the set.
		Set<Map.Entry<Character, Integer>> entrySet = treeMap.entrySet();
		Set<Map.Entry<Character, Integer>> sortedSet = new TreeSet<>(myComparator);
		for(Map.Entry<Character, Integer> entry: entrySet){
			sortedSet.add(entry);
		}
		for(Map.Entry<Character, Integer> entry: sortedSet){
			for(int i=0; i<entry.getValue(); i++){
				sb.append(entry.getKey());
			}
		}
		return sb.toString();
	}
}
