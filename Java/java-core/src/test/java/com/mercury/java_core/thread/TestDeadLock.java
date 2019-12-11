package com.mercury.java_core.thread;
/*	time slice
 * 	t1 lock: alice, before bow-back, lost time slice.
 * 	t2 lock: bob
 * 	Then bow back: 不管哪个线程， alice 和 bob 的锁都拿不到
 * 	这里的 锁 是 instance 锁。 调用的是 another.bowBack(this), 需要的
 *  的锁已经被另一个线程拿到了。
 * 
 * 	alice 是一个 object, 有两个 synchronized method, 每进一个 method 
 *  都需要 alice 这个锁。如果两个线程，运行两个 method，对于同一个 alice 都不行。
 * 
 * 	The sequence of acquiring of lock is different:
 * 	t1: acquiring alice then bob.
 * 	t2: acquiring bob then alice.
 * 	So the dead lock will happend
 * 
 * */

public class TestDeadLock {
    private static class Friend {
        String name;
        public Friend(String name) {
            this.name = name;
        }
        public synchronized void bow(Friend another) {
            System.out.println(name + " bows to " + another.name);
            another.bowBack(this);
        }
        public synchronized void bowBack(Friend another) {
            System.out.println(name + " bows back to " + another.name);
        }
    }
    public static void main(String[] args) throws Exception {
        Friend alice = new Friend("Alice");
        Friend bob = new Friend("Bob");
        Thread t1 = new Thread() {
            @Override
            public void run() {
                alice.bow(bob);
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                bob.bow(alice);
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("End of Main");
    }
}






