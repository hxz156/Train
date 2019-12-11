package com.mercury.java_core.colletion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.mercury.java_core.collection.DesendingComparator;
import com.mercury.java_core.collection.NameAgeComparator;
import com.mercury.java_core.collection.UserAgeComparator;
import com.mercury.java_core.oop.User;

public class TestSorting {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(38);
		list.add(2);
		System.out.println(list);
		
		// collection: interface of List, Set
		// collections: class
		Collections.sort(list);
		System.out.println(list);
		
		// comparator: define custom comparing logic
		Collections.sort(list, new DesendingComparator());
		System.out.println(list);
		
		List<User> users = new ArrayList<>();
		users.add(new User("bob", 21));
		users.add(new User("alice", 23));
		users.add(new User("alex", 25));
		Collections.sort(users, new UserAgeComparator());
		System.out.println(users);
		
		// comparable
		// is used to define comparing logic inside class itself
		// If users is comparable, then we can use Collections.sort()
		Collections.sort(users);
		System.out.println(users);
		
		/*home2
		 * 3. create a comparator to sort user by name first, and then by age.
		 * */ 
		List<User> alist = new ArrayList<>();
		alist.add(new User("bob", 21));
		alist.add(new User("alice", 23));
		alist.add(new User("alex", 25));
		alist.add(new User("alex", 27));
//		Collections.sort(alist, new NameAgeComparator());
		
		Comparator<User> lambdaCom = (u1, u2) -> {
			if (u1.getName().equals(u2.getName())) {
				return u1.getAge() - u2.getAge();
			} else {
				return u1.getName().compareTo(u2.getName());
			}
		};
		
		Collections.sort(alist, lambdaCom);
		System.out.println("--------alist-----------");
		System.out.println(alist);
		
	}

}










