package com.mercury.java_core.oop;
import java.io.FileNotFoundException;

public class TestOverrideException {

	// 只要继承 Exception 就是 checked exception:
	// checked exception:
	class CE1 extends Exception {}
	
	// checked exception:
	class CE2 extends CE1 {}
	
	// unchecked exception:
	class UCE1 extends RuntimeException {}
	
	// unchecked exception:
	class UCE2 extends UCE1 {}
	
	class A {
		public void test1() {
		}
		
		public void test2() throws UCE1 {
		}
		
		public void test3() throws CE1{
		}
		
	}
	
	// 可能： checked exception > (unchecked exception = no exception)
	class B extends A {
		// 1. parent method no exception.
		// child method is allowed to throw no exception.
		// child method is NOT allowed to throw checked exception.
		// child method is allowed to throw any unchecked exception.
		@Override
		public void test1() throws UCE1 {
			
		}
		
		// 2. parent method throws unchecked exception
		// child method is allowed to throw no exception.
		// child method is NOT allowed to throw checked exception.
		// child method is allowed to throw any unchecked exception.
		@Override
		public void test2() throws NullPointerException{
			
		}
		
		// 3. parent method throws checked exception
		// child method is allowed to throw no exception.
		// child method is allowed to throw checked exception which must be same or
		// subclass type exception of parent exception.
		// child method is allowed to throw any unchecked exception.
		@Override
		public void test3() {
			
		}
	}

}





