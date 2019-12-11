package com.mercury.java_core.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TestStreamAPIForLoops {

	public static void main(String[] args) {
		// array 有一个部分为 null，因为 size 赋予了长度。
		
		Integer[] arr = { 1, 1, 2, 3, 4, 5 };
		Integer[] temp = new Integer[arr.length];
		
		// 1. remove duplicates {1, 2, 3, 4, 5};
		Arrays.sort(arr);
		int j=0;
		for(int i=0; i<arr.length-1; i++){
			if(arr[i] != arr[i+1]){
				temp[j++] = arr[i];
			}
		}
		temp[j++] = arr[arr.length - 1];
		arr = new Integer[j++];
		for(int i=0; i<arr.length; i++){
			arr[i] = temp[i];
		}
		printArray(arr);
		
		// 2. sort in descending order {5,4,3,2,1}
		Comparator<Integer> myComp = (i1, i2) -> i2 - i1;
		Arrays.sort(arr, myComp);
		printArray(arr);
		
		// 3. double all numbers {10,8,6,4,2}
		for(int i=0; i<arr.length; i++){
			arr[i] = arr[i] * 2;
		}
		printArray(arr);
		
		// 4. remove all numbers which can divided by 3 {10,8,4,2}
		temp = new Integer[arr.length];
		j = 0;
		for(int i=0; i<arr.length; i++){
			if(arr[i] % 3 != 0){
				temp[j++] = arr[i];
			}
		}
		arr = new Integer[j++];
		for(int i=0; i<arr.length; i++){
			arr[i] = temp[i];
		}
		printArray(arr);
		
		// 5. output 2 numbers from the 2nd one {8,4}
		for(int i=1; i<=1+1; i++){
			System.out.print(arr[i]);
		}
	}
	
	static void printArray(Integer[] array){
		int len = array.length;
		for(int i=0; i<len; i++){
			System.out.print(array[i]);
		}
		System.out.println(" ");
	}
	
}










