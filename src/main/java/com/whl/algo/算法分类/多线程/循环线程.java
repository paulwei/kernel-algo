package com.whl.algo.算法分类.多线程;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class 循环线程 {
    public static void main(String[] args) throws InterruptedException {
        下载线程 t = new 下载线程();
        t.start();
        Thread.sleep(10000);
        t.shutDown();
        System.out.println("Thread start");
    }
}

abstract class ShutDownThread extends Thread{
    private final AtomicBoolean interruptible=new AtomicBoolean(false);
    private final AtomicBoolean isRunning = new AtomicBoolean(true);//while循环开关
    private final CountDownLatch shutDownLatch = new CountDownLatch(1);
    public abstract void doWork() throws InterruptedException;
    @Override
    public void run(){
        try{
            while(isRunning.get()){
                doWork();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        shutDownLatch.countDown();
    }
    public void shutDown(){
        initateShuDown();
        awaitShutDown();
    }
    public void initateShuDown(){
        if(isRunning.compareAndSet(true,false)){
            System.out.println("isRunning set false");
            if(interruptible.get()){
                interrupt();
            }
        }else{
            System.out.println("isRunning set false failured cas");
        }
    }
    public void awaitShutDown(){
        try{
            shutDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class 下载线程 extends ShutDownThread{
    private  volatile boolean isRunning=false;//while循环开关
    private  volatile ReentrantLock lock = new ReentrantLock();
    @Override
    public void start(){
        if(!isRunning){
            synchronized (this){
                if(!isRunning){
                    isRunning=true;
                    super.start();
                }else{
                    System.out.println("has being started");
                }
            }
        }else{
            System.out.println("has being started");
        }
    }
    @Override
    public void shutDown(){
        if(isRunning){
            synchronized (this){
                if(isRunning){
                    isRunning=false;
                    super.shutDown();
                }else{
                    System.out.println("has being stopped");
                }
            }
        }else{
            System.out.println("has being stopped");
        }
    }
    @Override
    public void doWork() throws InterruptedException {
        while (isRunning){
            boolean accquired = lock.tryLock(2000,TimeUnit.MILLISECONDS);
            if(accquired){
                try {
                    System.out.println(Thread.currentThread().getName()+" 下载线程中...."+(System.currentTimeMillis()/1000));
                    TimeUnit.MILLISECONDS.sleep(1000);
                }catch (Throwable t){
                    t.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }else{
                System.out.println("获取锁失败");
            }
        }
    }
}
