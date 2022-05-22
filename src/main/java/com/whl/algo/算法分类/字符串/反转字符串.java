package com.whl.algo.算法分类.字符串;

/*
* 反转第 K个之前字符串
* 思路:首位双指针交换
* */
public class 反转字符串 {

    public static void main(String[] args) {
        String str ="abcdefg";
        String ans = reverseString(str,str.length()-1);
        System.out.println(ans);
    }

    private static String reverseString(String s, int end) {
        //找出口，当end为0时，到达第一个元素
        if(end==0)
            return ""+s.charAt(0);
        //找重复，是原问题的子问题
        return s.charAt(end)+reverseString(s,end-1);
    }
}
