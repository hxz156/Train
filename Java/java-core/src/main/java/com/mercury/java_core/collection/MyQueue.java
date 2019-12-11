package com.mercury.java_core.collection;

import java.util.Stack;

public class MyQueue<T> {

	// use two stacks to implement queue
	// MyQueue
	Stack<T> stackStore = new Stack<>();
	Stack<T> stackTemp = new Stack<>();

	public void offer(T offer) {
		stackStore.push(offer);
	}

	public T poll() {
		if (!stackStore.empty()) {
			reverseStackEmptyFirstStack(stackStore, stackTemp);
			T value = stackTemp.pop();
			reverseStackEmptyFirstStack(stackTemp, stackStore);
			return value;
		} else {
			return null;
		}
	}

	void reverseStackEmptyFirstStack(Stack<T> stack1, Stack<T> stack2) {
		while (!stack1.empty()) {
			stack2.push(stack1.pop());
		}
	}

}
