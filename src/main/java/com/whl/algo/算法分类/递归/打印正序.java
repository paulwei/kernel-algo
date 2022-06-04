package com.whl.algo.算法分类.递归;

/*
* 输入n，打印1...n
*
* */
public class 打印正序 {
    public static void main(String[] args) {
        print(10);
    }

    public static void print(int n){
        if(n>1){
            print(n-1);
        }
        System.out.println("n:"+n);
    }
}
