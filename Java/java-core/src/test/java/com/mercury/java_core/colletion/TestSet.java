package com.mercury.java_core.colletion;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import com.mercury.java_core.collection.DesendingComparator;
import com.mercury.java_core.oop.User;

public class TestSet {

	public static void main(String[] args) {
		Set<Integer> s1 = new HashSet<>();
		s1.add(33);
		s1.add(8);
		s1.add(1);
		s1.add(8);
		System.out.println(s1);
		
		// will sort the set by default 
		Set<Integer> s2 = new TreeSet<>();
//		Set<Integer> s2 = new TreeSet<>(new DesendingComparator());
		s2.add(15);
		s2.add(14);
		s2.add(13);
		System.out.println(s2);
		
		// will reserved the insertion order.
		Set<Integer> s3 = new LinkedHashSet<>();
		s3.add(33);
		s3.add(8);
		s3.add(1);
		s3.add(8);
		System.out.println(s3);
		
		// u1.hashCode() == u2.hashCode() && u1.equals(u2)
		// 因为 hashCode() 和 .equals() 一样，所以 set 里面只有一个
		Set<User> users = new HashSet<>();
		users.add(new User("Bob", 21));
		users.add(new User("Bob", 21));
		System.out.println(users);
	}
}


