package com.java.thread.type;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 线程交替打印 {
    public static void main(String[] args) {
        fun1();
//        fun2();
//        fun3();
    }

   //notify wait
    public static void fun1(){
        final char[] c1 = "123456789".toCharArray();
        final char[] c2 = "ABCDEFGHI".toCharArray();
        Object lock= new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    for(char c:c1){
                        System.out.println(c);
                        try {
                            lock.notify();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notify();//总有线程最后 wait,需要 notify唤醒
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    for(char c:c2){
                        System.out.println(c);
                        try {
                            lock.notify();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notify();
                }
            }
        });
        t1.start();
        t2.start();
    }

    static volatile boolean flag = true;
    static int i=0;
    static int j=0;
    //volatile
    public static void fun2(){
        final char[] c1 = "123456789".toCharArray();
        final char[] c2 = "ABCDEFGHI".toCharArray();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (i<c1.length)
                    if(flag){
                        System.out.println(c1[i++]);
                        flag=false;
                    }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (j<c2.length)
                    if(!flag){
                        System.out.println(c2[j++]);
                        flag=true;
                    }
            }
        });
        t1.start();
        t2.start();
    }

    public static void fun3(){
        final char[] c1 = "123456789".toCharArray();
        final char[] c2 = "ABCDEFGHI".toCharArray();
        ReentrantLock lock = new ReentrantLock();
        Condition lock1 = lock.newCondition();
        Condition lock2 = lock.newCondition();
        new Thread(() -> {
            if(lock.tryLock()){
                for(char c:c1) {
                    System.out.println(c);
                    try {
                        lock2.signalAll();
                        lock1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
                lock1.signalAll();
            }}).start();
        new Thread(() -> {
            if(lock.tryLock()){
                for(char c:c2) {
                    System.out.println(c);
                    try {
                        lock1.signalAll();
                        lock2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock2.signalAll();
            }

        }).start();
    }
}
