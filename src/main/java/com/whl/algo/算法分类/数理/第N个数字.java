package com.whl.algo.算法分类.数理;

import java.util.Stack;

/*
 * 给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字
 * 输入：n = 3 输出：3，第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 * 思路:
 * 思路如下：
  1 ... 9 有 9 个一位数，共有 9 * 1 位
  10 ... 99 有 90 个两位数，共有 90 * 2 位
  100 ... 999 有 900 个三位数，共有 900 * 3 位


 * */
public class 第N个数字 {
    public static int findKthDigit(int n){
        if(n<10){
            return n;
        }
        int i = 1;
        while (true){
            Stack<Integer> stack = split(i);
            while (!stack.isEmpty()){
              Integer k = stack.pop();
              if(i==n){
                  return k;
              }
              i++;
            }
        }
    }

    public static Stack<Integer> split(int n){
        Stack<Integer>  stack = new Stack<>();
        while (n>0){
            int digit = n%10;
            stack.push(digit);
            n/=10;
        }
        return stack;
    }

    public static void main(String[] args) {
        int n = 11;
       int ans = findKthDigit(n);
        System.out.println(ans);
    }
}
