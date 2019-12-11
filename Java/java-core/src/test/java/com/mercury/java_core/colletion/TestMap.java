package com.mercury.java_core.colletion;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.mercury.java_core.oop.User;

public class TestMap {

	public static void main(String[] args) {
		// User : 91
		Map<User, Integer> hmap = new HashMap<>();
		User user1 = new User("bob", 21);
		User user2 = new User("alice", 23);
		User user3 = new User("alex", 22);
		User user4 = new User("jack", 27);
		hmap.put(user1, 92);
		hmap.put(user2, 80);
		hmap.put(user3, 100);
		hmap.put(user4, 82);
		System.out.println(hmap);
		
		// entry(Node): key-value pair
		Comparator<User> userAgeDescComp = new Comparator<User>(){
			@Override
			public int compare(User o1, User o2) {
				
				return o2.getAge() - o1.getAge();
			}
		};
		
		Map<User, Integer> tmap = new TreeMap<>(userAgeDescComp);
		tmap.put(user1, 92);
		tmap.put(user2, 80);
		tmap.put(user3, 100);
		System.out.println(tmap);
		
		// how to print(loop through/iterate) a HashMap?
		// bob: 92,	alice: 80,	alex: 100,	jack: 82
		
		// 1. keySet()
		System.out.println("** keySet() **");
		Set<User> keys = hmap.keySet();
		for(User key : keys){
			System.out.println(key.getName() + ": " + hmap.get(key));
		}
		
		// 2. entrySet()
		System.out.println("** entrySet() **");
		Set<Map.Entry<User, Integer> > entries = hmap.entrySet();
		for(Map.Entry<User, Integer> entry : entries){
			System.out.println(entry.getKey().getName() + ": " +
								entry.getValue());
		}
		
		Comparator<Map.Entry<User, Integer>> hmapComp = new 
				Comparator<Map.Entry<User, Integer>>(){

					@Override
					public int compare(Entry<User, Integer> o1, Entry<User, Integer> o2) {
						return o2.getValue() - o1.getValue();
					}
		};
		
		// using Lambda to implement above Comparator:
		Comparator <Map.Entry<User, Integer>> myComp = (e1, e2) -> 
									(e2.getValue() - e1.getValue());
		
		// practice LinkedHashMap. sort the hmap by score(value) in descending 
		// order. (change hmp to a LinkedHashMap(), using keySet() or
		// entrySet())
		System.out.println("** sort the hmap by score(value) in descending **");
		Set<Map.Entry<User, Integer>> myEntry = hmap.entrySet();
//		Set<Map.Entry<User, Integer>> sortEntry = new TreeSet<>(myComp);
		Set<Map.Entry<User, Integer>> sortEntry = new TreeSet<>((e1, e2) -> 
						e2.getValue() - e1.getValue());
		
		for(Map.Entry<User, Integer> entry : myEntry){
			sortEntry.add(entry);
		}
		
		for(Map.Entry<User, Integer> entry : sortEntry){
			hmap.put(entry.getKey(), entry.getValue());
		}
		System.out.println(hmap); 
		
	}

}












