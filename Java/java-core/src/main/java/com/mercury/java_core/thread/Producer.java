package com.mercury.java_core.thread;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	BlockingQueue<Integer> bq;

	public Producer(BlockingQueue<Integer> bq) {
		super();
		this.bq = bq;
	}

	@Override
	public void run() {
		// produce data and save in Blocking queue
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(10);
				bq.put(i);
				System.out.println("Producer " + Thread.currentThread().getName() + ": " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
