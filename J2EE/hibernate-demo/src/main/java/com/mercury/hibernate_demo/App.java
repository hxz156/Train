package com.mercury.hibernate_demo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String str = "abc d";
        System.out.println( reverse(str) );
    }
    public static String reverse(String str) {
    	if(str.length() == 0) return str;
    	return reverse(str.substring(1)) + str.charAt(0);
    }
}
