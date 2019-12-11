package com.mercury.java_core.thread;

public class TestThreadLocal {
	   static class Data {
	        int x = 10;
	        // a thread local object which contains 20.
	        // A new thread will get a copy of y automatically by java.
	        ThreadLocal<Integer> y = new ThreadLocal<Integer>(){
				@Override
				protected Integer initialValue() {
					return 20;
				}
	        };
	    }
	   
	    public static void main(String[] args) {
	        Data data = new Data(); 
	        
	        // new requirement: make each thread to have
	        // its own copy of x
	        // local copy of data to each thread
	        Thread t1 = new Thread(() -> {
	            data.x++;
	            System.out.println(data.x + " in t1");
	            
	            data.y.set(data.y.get() + 1);
	            System.out.println(data.y.get() + " y in t1");
	        });
	        
	        Thread t2 = new Thread(() -> {
	            data.x++;
	            System.out.println(data.x + " in t2");
	            
	            data.y.set(data.y.get() - 1);
	            System.out.println(data.y.get() + " y in t2");
	        });
	        t1.start();
	        t2.start();
	        
	        System.out.println(data.y.get() + " end of y value");
	    }

}







