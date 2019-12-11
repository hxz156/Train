package com.mercury.java_core.thread;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	BlockingQueue<Integer> bq;
	
	public Consumer(BlockingQueue<Integer> bq) {
		super();
		this.bq = bq;
	}

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(50);
				// thread will be blocking if no data available
				Integer data = bq.take();
				System.out.println("Consumer " + Thread.currentThread().getName() + ": " + data);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}




