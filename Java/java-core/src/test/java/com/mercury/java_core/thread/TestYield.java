package com.mercury.java_core.thread;

public class TestYield {
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				if (i % 2 != 0) {
					System.out.println(i);
					Thread.yield(); // t1 will give up CPU time slice, go back
									// to runnable pool.
				}
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				if (i % 2 != 0) {
					System.out.println(i);
					Thread.yield();
				}
			}
		});
		t1.start();
		t2.start();
	}
}
