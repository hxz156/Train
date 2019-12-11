package com.mercury.java_core.thread;

public class TestDaemonThread {

	static void delay(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            int i = 0;
            while(true) {
                delay(1000);
                System.out.println(i);
                i++;
            }
        });
        t.setDaemon(true); // make t to be a Daemon thread, then after main thread done
        					// t thread will die immediately
        t.start();
        
        delay(5000);
        System.out.println("end of main");
    }

}









