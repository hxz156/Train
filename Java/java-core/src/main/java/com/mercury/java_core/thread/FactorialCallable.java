package com.mercury.java_core.thread;
import java.util.concurrent.Callable;

public class FactorialCallable implements Callable<Long> {

	private int num;

	public FactorialCallable(int num) {
		this.num = num;
	}

	public long factorial(int i) {
		return i == 0 ? 1 : factorial(i - 1) * i; // 阶乘
	}

	@Override
	public Long call() throws Exception {
		Thread.sleep(5 * num);
		return factorial(num);
	}

}













