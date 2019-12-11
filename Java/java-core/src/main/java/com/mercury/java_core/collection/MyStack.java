package com.mercury.java_core.collection;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack<T> {
	// use queue to implement stack
	// MyStack
	Deque<T> dequeStore = new ArrayDeque<>();
	Deque<T> dequeTemp = new ArrayDeque<>();

	// void push()
	public void push(T push) {
		dequeStore.offer(push);
	}

	// T pop()
	public T pop() {
		if (!dequeStore.isEmpty()) {
			reverseDequeEmptyFirstDeque(dequeStore, dequeTemp);
			T value = dequeTemp.poll();
			reverseDequeEmptyFirstDeque(dequeTemp, dequeStore);
			return value;
		} else {
			return null;
		}
	}

	public void reverseDequeEmptyFirstDeque(Deque<T> deque1, Deque<T> deque2) {
		while (!deque1.isEmpty()) {
			deque2.offer(deque1.poll());
		}
	}
}
