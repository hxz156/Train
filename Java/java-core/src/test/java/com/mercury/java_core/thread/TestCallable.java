package com.mercury.java_core.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallable {

	public static void main(String[] args) {
		// Callable must be executed by thread pool.
		// 一般会用 thread pool 去创建 thread 而不是 new thread
		ExecutorService pool = Executors.newSingleThreadExecutor();
		
		FactorialCallable c = new FactorialCallable(10);
		Future<Long> future = pool.submit(c); // 把 callable 发给线程值，线程值会去执行
		
		try {
			// get() is a blocking method. main thread will be blocked
			// until Callable thread will be finished
			System.out.println(future.get()); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		pool.shutdown();
	}
}
