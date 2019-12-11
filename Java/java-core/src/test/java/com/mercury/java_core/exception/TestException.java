package com.mercury.java_core.exception;

import com.mercury.java_core.oop.SuperUser;
import com.mercury.java_core.oop.User;

class CheckIException extends Exception{
	public CheckIException(String message) {
		super(message);
	}
}

// Or extends Error (This is unchecked exception)
class CheckJException extends RuntimeException{
	public CheckJException(String message){
		super(message);
	}
}

public class TestException {
	// Test checked exception
	public static void test1(int i) throws CheckIException { // a class: throws
		if (i > 0) {
			System.out.println(i);
		} else {
			throw new CheckIException("I must be positive !");
		}
	}

	// Test unchecked exception
	public static void test2(int j){
		if(j < 0) {
			System.out.println(j);
		} else {
			throw new CheckJException("J must be negative !");	// a method: throw
		}
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		// checked
		User user = new User("bob", 21);
		try {
			User user1 = user.clone();
//			System.exit(0);
			//return;	// finally will be executed even if return 
		} catch(CloneNotSupportedException e) {
			System.err.println("User does not support clone. ");
		} finally {
			// finally will always run no matter there is exception or not.
			System.out.println("We tried to clone user. ");
			
		}
		
//		try {
//			test1(-10);
//		} catch(CheckIException e){
//			System.err.println(e);
//		}
		
		SuperUser su = new SuperUser();
		SuperUser su1 =  (SuperUser) su.clone();
		System.out.println(su1);
	}

}





