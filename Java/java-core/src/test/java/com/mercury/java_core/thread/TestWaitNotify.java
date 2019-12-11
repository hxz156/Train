package com.mercury.java_core.thread;

public class TestWaitNotify {

	public static void main(String[] args) {
		// how to print alternatively for all even and odd numbers under 10?
		// t1 或者 t2 完成一次打印，就放弃 time slice。交替打印

		// 任何一个 object 都可以当作 monitor
		Object monitor = new Object();

		Thread t1 = new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				if (i % 2 != 0) {
					System.out.println(i);
					synchronized (monitor) { // synchronized:
												// 在去睡的过程中，不希望另一个 thread 去唤醒
						monitor.notify();
						try {
							monitor.wait(); // 当前 thread 去睡，等待唤醒。
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				if (i % 2 == 0) {
					System.out.println(i);
					synchronized (monitor) { // 防止 睡/唤醒 同时进行，而错乱
						monitor.notify(); // t1 will be notified to wake up.
						try {
							monitor.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		t1.start();
		t2.start();
	}
}
