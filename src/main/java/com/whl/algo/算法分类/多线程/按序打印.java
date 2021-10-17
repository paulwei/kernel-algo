package com.whl.algo.算法分类.多线程;

import java.util.concurrent.atomic.AtomicInteger;

/*
*
* public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}
三个不同的线程 A、B、C 将会共用一个 Foo 实例。

一个将会调用 first() 方法
一个将会调用 second() 方法
还有一个将会调用 third() 方法
* */
public class 按序打印 {
    public static void main(String[] args) {
        final Foo foo = new Foo();
        AtomicInteger counter = new AtomicInteger();
        Thread first = new Thread(new Runnable() {
            @Override
            public void run() {
                while (counter.getAndIncrement()==0){
                    foo.first();;
                }

            }
        });
        Thread second = new Thread(new Runnable() {
            @Override
            public void run() {
                while (counter.getAndIncrement()==1){
                    foo.second();
                }

            }
        });
        Thread third = new Thread(new Runnable() {
            @Override
            public void run() {
                while (counter.getAndIncrement()==2){
                    foo.third();;
                }

            }
        });
        first.start();
        second.start();
        third.start();

    }


}

 class Foo {
   public void first() {System.out.println("first");}
   public void second() {System.out.println("second");}
   public void third() {System.out.println("third");}
}