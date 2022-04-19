package com.whl.algo.算法分类.递归;

public class X平方根 {

    public static int  sqrt(int x){
        if(x==0){
            return 0;
        }
        int r  = sqrt(x-1);
        int r2 = r+1;
        if(x<r2*r2){
            return r;
        }
        return r+1;
    }

    public static void main(String[] args) {
        int x = 16;
        int n = sqrt(x);
        System.out.println(n);
    }
}
