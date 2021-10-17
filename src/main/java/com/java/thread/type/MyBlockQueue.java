package com.java.thread.type;

import java.util.LinkedList;
import java.util.Queue;

/*
*
*  offer属于 offer in interface Deque<E>，add 属于 add in interface Collection<E>。
*  当队列为空时候，使用add方法会报错，而offer方法会返回false。
*  作为List使用时,一般采用add / get方法来 压入/获取对象。
*  使用take()函数，如果队列中没有数据，则线程wait释放CPU，而poll()则不会等待，直接返回null；linkedList 无,只有 ArrayBlockingQueue 有take方法
*  poll：将首个元素从队列中弹出，如果队列是空的，就返回null
*  peek：查看首个元素，不会移除首个元素，如果队列是空的就返回null
*  element：查看首个元素，不会移除首个元素，如果队列是空的就抛出异常NoSuchElementException
* *
*/

public class MyBlockQueue<T> {
    private Queue<T> queue = new LinkedList();
    public int max;
    public MyBlockQueue(int max) {
        this.max = max;
    }

    public void put(T t) throws InterruptedException {
        synchronized (this){
            if(queue.size()==max){
                this.wait();//达到最大数量,当前线程阻塞,释放锁,由其他线程对该对象访问notify唤醒
            }
            queue.offer(t);
            this.notify();
        }
    }

    public T  get() throws InterruptedException {
        T t;
        synchronized (this){
            if(queue.size()==0){
                this.wait();//当前队列空,当前线程阻塞,释放锁,由其他线程对该对象访问notify唤醒
            }
            t = queue.poll();
            this.notifyAll();
        }
        return t;
    }

    public static void main(String[] args) {
       final MyBlockQueue myBlockQueue = new  MyBlockQueue(20);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0 ;i<100;i++){
                    try {
                        myBlockQueue.put(i);
                        System.out.println(String.format("put i:%s",i));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0 ;i<100;i++){
                    try {
                        myBlockQueue.get();
                        System.out.println(String.format("get i:%s",i));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t2.start();
    }

}
