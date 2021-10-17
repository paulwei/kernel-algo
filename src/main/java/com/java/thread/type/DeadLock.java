package com.java.thread.type;

public class DeadLock {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1){
                    System.out.println("t1 run accquire lock1 ");
                    try {
                        Thread.sleep(1000*5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2){
                        System.out.println("t1 run accquire lock2 ");
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2){
                    System.out.println("t2 run accquire lock2 ");
                    try {
                        Thread.sleep(1000*5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1){
                        System.out.println("t2 run accquire lock1 ");
                    }
                }
            }
        }).start();
    }
}
