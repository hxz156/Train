package com.mercury.java_core.thread;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class MyIntList {
	int[] table = new int[1];
	int size = 0;
	static int total = 0;
	static AtomicInteger ai = new AtomicInteger(0);

	// synchronized 不再允许多个线程同时访问, thread safe
	public synchronized void add(int x) {
		if (size >= table.length) {
			// left shift by 1 == * 2
			table = Arrays.copyOf(table, table.length << 1);

		}
		table[size] = x;
		size++;
	}

	// ======================================================================================
	// non-static synchronized method, lock is the instance which is used to invoke the
	// method
	// Although it is synchronized, but a non-static method lock belongs to
	// object
	// So different instances of objects still could work on the same method on the same
	// time.
	public synchronized void test() {
		for (int i = 0; i < 10000; i++) {
			total++; // not atomic because:
			// step 1. newTotal = total + 1
			// step 2. total = newTotal

		}
	}

	// static method: the lock is the class itself.
	public synchronized static void test1() {
		for (int i = 0; i < 10000; i++) {
			total++; // not atomic because:
			// step 1. newTotal = total + 1
			// step 2. total = newTotal
		}
	}

	// ==============================================================================
	// synchronized block: lock part of a method
	public void test2(){
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("hello");
		System.out.println("hello");
		
		// this -> called of the method, point to the specific Object who call
		// then the Object get the lock. Object level lock. (this only can be used in non-static)
		// Method 变成 synchronized 为了节省资源，前面的 printout 没有必要 synchronized 的时候就用
		synchronized (this){
			total++;
		}
		
		// This is Class level lock. Protect this part from running under different instance
		// although it is not static method. (For static method, the lock is automatically class
		// level lock)
		synchronized (MyIntList.class){
			total++;
		}
	}

	// ===============================================================================
	// not thread safe seems: (But we have atomic operation, the output is all good.)
	// Then use atomic operation to achieve thread safe. 就不会做到一半，丢失 time slice (key)
	public static void test3() {
		for (int i = 0; i < 10000; i++) {
			// atomic operation
			ai.getAndIncrement(); // increase ai by 1 and set back to ai in one step
//			ai.getAndSet(10);
		}
	}
	
	//===============================================================================
	
	
	@Override
	public String toString() {
		return Arrays.toString(table);
	}

}
