package com.whl.algo.算法分类.数理;

import java.util.Stack;

/*
* 输入987，输出9,8,7
* 循环取余
* */
public class 拆分整数 {
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
        int n = 987;
        Stack<Integer> stack =  split(n);
        while (!stack.isEmpty()){
         Integer  s = stack.pop();
         System.out.println(s);
        }
    }
}
