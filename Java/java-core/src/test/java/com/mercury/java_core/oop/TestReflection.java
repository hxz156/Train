package com.mercury.java_core.oop;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestReflection {

	public static void main(String[] args) throws NoSuchFieldException, 
	SecurityException, IllegalArgumentException, IllegalAccessException, 
	InvocationTargetException {
		String s = "abc";
		char[] ca = {'d', 'e', 'f'};
		
		// Reflection
		Field valueField = String.class.getDeclaredField("value");
		valueField.setAccessible(true);
		valueField.set("abc", ca);
		
		System.out.println(s);
		System.out.println("abc");	// "def"
		
		
		List<Parent> parents = new ArrayList<Parent>();
		parents.add(new Child());
		parents.add(new Child1());
		
		System.out.println("*****************************");
		for(Parent p : parents){
			// if p has magic method, invoke magic method.
			Method[] methods = p.getClass().getDeclaredMethods();
			for(int i=0; i<methods.length; i++){
				System.out.println(methods[i].getName());
				if(methods[i].getName().equals("magic")){
					methods[i].invoke(p);
				}
			}
		}
		System.out.println("*****************************");
		
	}

}












