package com.mercury.java_core.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class TestBlockingQueue {

	public static void main(String[] args) {
		BlockingQueue<Integer> bq = new LinkedBlockingDeque<>();

		Thread p1 = new Thread(new Producer(bq));
		p1.start();

		// 两个 consumer 去消费：
		Thread c1 = new Thread(new Consumer(bq));
		c1.start();
		Thread c2 = new Thread(new Consumer(bq));
		c2.start();
		
		// 假设想要更多的 consumer，需要去创建更多的 thread.
		// 100.
		// 1 thread: create/start/destroy (10ms), running(20ms), destroy(2ms)
		// 100 -> 3000ms (没有必要一次性创造出来 100 个线程)

		// Thread Pool: reuse existing created thread to improve performance
		// Create a thread pool to run 4 threads: 40ms.
		// total task: 2000ms
		// final duration: 2040ms

		// 每次最多 创建/运行 4 个线程的 pool：
		ExecutorService pool = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 20; i++) {
			Consumer c = new Consumer(bq);
			pool.execute(c);
		}
//		pool.shutdown();
	}

}












