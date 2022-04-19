package com.whl.algo.算法分类.单调栈;

import com.alibaba.fastjson.JSON;

import java.util.Stack;

/*
* 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]下标相减
* 当前日保存第几天之后再升温
* */
public class 每日温度 {
    public static int[] dailyTemperature_Test2(int[] T) {
        int[] res  = new int[T.length];    //返回数组
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while(!stack.isEmpty() && T[i]>T[stack.peek()]){
                int record_num = i-stack.peek();       //while每次循环中，不要出栈两次
                res[stack.pop()]=record_num;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
       int[] temperatures ={73, 74, 75, 71, 69, 72, 76, 73};
       int[] res =  dailyTemperature_Test2(temperatures);
       System.out.println(JSON.toJSONString(res));
    }

}
