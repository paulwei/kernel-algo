package com.whl.algo.算法分类.单调栈;

import java.util.Stack;

/*
* 设计一个支持 push，pop，top 等操作并且可以在 O(1) 时间内检索出最小元素的堆栈。
* 设计一个函数可以获取栈中最小值
* 思路:双栈,另一栈存放每次入栈最小值
* */
public class Min函数的栈 {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int x){
        stack1.push(x);
        if(stack2.isEmpty() || stack2.peek()>x)
            stack2.push(x);
        else
            stack2.push(stack2.peek());
    }


    public int getMin(){
        return stack2.peek();
    }

}
