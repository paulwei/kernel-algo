package com.whl.algo.算法分类.递归;

/*
* 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
*
* */
public class 递归乘法 {

    public static int multi(int a,int b){
        if(a==0){
            return 0;
        }
        return b+multi(a-1,b);
    }

    public static void main(String[] args) {
       int ans = multi(5,9);
        System.out.println(ans);
    }
}
