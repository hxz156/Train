package com.mercury.java_core.oop;

public class Child extends Parent {
	
	int x = 2;
	static int y = 1;
	protected int z = 3;
	
	public Child(){
//		super(0);
		System.out.println("Child constructor executed! ");
	}
	
	void print() {
		System.out.println("Child print");
	}
	
	void run(){
		test();
		test(1);
	}
	
	void test(){
		
	}
	
	// overload of above method
	void test(int i){
		
	}
	
	// this method is the same as above, because when calling, Java
	// only know the name of the method
//	int test(int i){
//		return 1;
//	}
}











