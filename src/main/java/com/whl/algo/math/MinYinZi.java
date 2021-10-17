package com.whl.algo.math;

public class MinYinZi {
    public static void main(String[] args) {
        for(int i=0;i<10000;i++){
            if(i % 24==0 && i % 32 ==0 && i % 36==0){
                System.out.println(i);
            }
        }
    }
}
