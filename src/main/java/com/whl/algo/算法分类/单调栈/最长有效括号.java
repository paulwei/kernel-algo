package com.whl.algo.算法分类.单调栈;

import java.util.Deque;
import java.util.LinkedList;

/*
* 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
* 输入：s = ")()())"
* 输出：4
* 解释：最长有效括号子串是 "()()"
* 思路：
* */
public class 最长有效括号 {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') { //遇到左括号入栈
                stack.push(i);
            } else {
                stack.pop();  //遇到右括号出栈
                if (stack.isEmpty()) {//没有前匹配左括号，只右括号入栈
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());//当前索引- 栈中保留顶部索引为当前次长度
                }
            }
        }
        return maxans;
    }

}
