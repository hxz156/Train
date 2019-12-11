package com.mercury.java_core.java8;

// indicates we have only one abstract method:
@FunctionalInterface
public interface Flyable {
	
	// all the variables in an interface must be public static final
	// before Java 8, public abstract method without method body
	
	public abstract void fly();
	
	// after Java 8, we can have default/static method:
	// 默认所有的 implements Flyable 的都能 test1()， 可以直接 invoke
	// Java 8 之后，就可以在 interface 里面写 method body ，和 abstract class 相似
	// 但是 class 只能 extends 一个 class， 却能够 implements 很多 interface
	// 所以这个更新就很好
	
	/* Java 8 has introduced the concept of default methods which allow 
	 * the interfaces to have methods with implementation without affecting 
	 * the classes that implement the interface.
	 * 就算 class 不对这个 default methods implement, 这个 class 也可以用。
	 * */
	public default void test1(){
		System.out.println("This is default method in Flyable interface");
	}
	
	// This method is static, it belongs to interface, can only be invoked by Interface
	public static void test2(){
		System.out.println("This is static method test2() in Flyable interface");
	}
}




