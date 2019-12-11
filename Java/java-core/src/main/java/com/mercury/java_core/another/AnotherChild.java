package com.mercury.java_core.another;

import com.mercury.java_core.oop.Child;

public class AnotherChild extends Child{
	
	void print(){
		System.out.println(z);
	}
	
	public static void main(String[] args) {
		Child c = new Child();
		
		// System.out.println(c.z); 
		// c is not AnotherChild, so can not c.z. 
		// And this is protected defined in documentation. The z is protected.
		// Important
		
		AnotherChild ac = new AnotherChild();
		System.out.println(ac.z);
		ac.print();
	}

}






