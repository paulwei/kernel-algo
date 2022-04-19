package com.whl.algo.算法分类.单调栈;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Stack;

/*
* 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。在 S 上反复执行重复项删除操作，直到无法继续删除。在完成所有重复项删除操作后返回最终的字符串
* 输入："abbaca"
* 输出："ca"
* 思路:栈顶元素和当前元素相同一块出站移除,俄罗斯方块思想
* */
public class 删除字符串中的所有相邻重复项 {

    //思路双指针i,j不同时候同时后移,如果相同则只有j++
    public static String removeDuplicateDeep(char[] chars){
        Stack<Character> stack = new Stack<>();
        for(Character c:chars){
            if(!stack.isEmpty() && stack.peek().equals(c)){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        Character result[] = new Character[chars.length];
         stack.copyInto(result);
         return Arrays.toString(result);
    }

    public static void main(String[] args) {
        String s = "abbaca";
        String result = removeDuplicateDeep(s.toCharArray());
        System.out.println(JSON.toJSONString(result));
    }
}
