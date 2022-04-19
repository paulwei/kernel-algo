package com.whl.algo.算法分类.分治法;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/*
* Input: "2-1-1".
* ((2-1)-1) = 0
* (2-(1-1)) = 2
* Output : [0, 2]
*
* */
public class 给表达式加括号 {
    public static void main(String[] args) {
        String s="2-1-1";
        List<Integer> result = diffWaysToCompute(s);
        System.out.println(JSON.toJSONString(result));
    }
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new ArrayList<>();//局部变量
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));//左边[0,i)
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));//右边[i+1,lenth-1]
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                ways.add(l + r);//递归返回的结果
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (ways.size() == 0) {
//            System.out.println("ways.size==0 input:"+input+",ways"+JSON.toJSONString(ways));
            ways.add(Integer.valueOf(input));
        }
        System.out.println(Thread.currentThread().getStackTrace()+" ways:"+JSON.toJSONString(ways)+",input:"+JSON.toJSONString(input));
        return ways;
    }

}
