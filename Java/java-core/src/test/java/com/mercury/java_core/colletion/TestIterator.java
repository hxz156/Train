package com.mercury.java_core.colletion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestIterator {

	public static void main(String[] args) {
		List<Integer> list = new CopyOnWriteArrayList();
		
		list.add(1);
		list.add(2);
		list.add(3);
		
//		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//			list.remove(i);
//		}
		
//		Iterator<Integer> it = list.iterator();
//		while(it.hasNext()){ // iterator 阻止使用集合的时候 集合元素被修改。
							// 所以 list.remove() 就会出错。
//			System.out.println(it.next());
//			list.remove(0);
//		}
//		System.out.println(list);
		
		Iterator<Integer> it = list.iterator();
		int i = 0;
		while(it.hasNext()){ // iterator 阻止使用集合的时候 集合元素被修改。
							// 但是 list.set() 可以修改。
			System.out.println(it.next());
			list.set(i, -i);
		}
		System.out.println(list);
	}
}




