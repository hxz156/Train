package com.mercury.java_core.oop;
public class TestString {
	
	public static void main(String[] args) {
		String s1 = "abc";	// String literal -> new String("abc")
		String s2 = "abc";
		String s3 = new String("abc");	// Create an Object in Heap memo
		
		System.out.println(s1 == s2);		// true
		System.out.println(s1.equals(s2));	// true
		System.out.println(s1 == s3);		// false
		System.out.println(s1.equals(s3));	// true
		
		String s4 = new String("def");
		// how many objects are created? (2)
		// 1. String pool ("def")	2. new Object
		
		String s5 = "hello" + "world";		// "helloworld" in String pool
		System.out.println(s5);
		String s6 = "helloworld";
		System.out.println(s5 == s6);
		
		// intern()
		// it will check if current string is in string pool
		// or not, if in string pool, return the string in
		// string pool, otherwise, create the string in string pool 
		// and return.
		
		System.out.println(s3.intern());
		System.out.println(inPool(s1));
		System.out.println(inPool(s3));
		System.out.println(inPool(s3));
		System.out.println(inPool("kk3332"));
		System.out.println(inPool("kk3332"));
	}
	
	public static boolean inPool(String str){
		return str == str.intern();
	}

}










