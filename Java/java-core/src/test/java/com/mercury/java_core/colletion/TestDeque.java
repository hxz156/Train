package com.mercury.java_core.colletion;

import java.util.ArrayDeque;
import java.util.Deque;

import com.mercury.java_core.collection.MyQueue;
import com.mercury.java_core.collection.MyStack;

public class TestDeque {

	public static void main(String[] args) {
		// deque can be used as queue as well as stack

		Deque<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		
		// use two stacks to implement queue
		// MyQueue
		System.out.println("** MyQueue: **");
		MyQueue<Integer> myQueue = new MyQueue<>();
		myQueue.offer(10);
		myQueue.offer(20);
		myQueue.offer(30);
		System.out.println(myQueue.poll());
		System.out.println(myQueue.poll());
		System.out.println(myQueue.poll());
		
		// use queue to implement stack
		// MyStack
		System.out.println("** MyStack: **");
		MyStack<Integer> myStack = new MyStack<>();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		
	}

}







