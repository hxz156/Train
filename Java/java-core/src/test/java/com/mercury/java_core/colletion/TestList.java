package com.mercury.java_core.colletion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestList {
	public static void main(String[] args) {
		
		List<Integer> alist = new ArrayList<>();
		alist.add(2);
		alist.add(8);
		alist.add(3);
		
		System.out.println(alist);
		System.out.println(alist.get(1));
		
		
//		 ArrayList
//		 constructors
//		 Object[] elementData
//		 capacity
//		 add()
//		 get()
//		 grow() -> resize arrayList. 1.5 times
		
		List llist = new LinkedList();
		llist.add(3);
		llist.add(8);
		llist.add(8);
		System.out.println(llist);
		System.out.println(llist.get(2));
	}
	
	
}




