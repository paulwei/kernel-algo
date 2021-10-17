package com.whl.algo.算法分类.数组;

/*
* 单指针即可,相同前缀,索引相同
* */
public class 数组公共前缀 {
    public static void main(String[] args) {

    }
    public static String longestCommonPrefix(String s1,String s2){
        int index =0;
        int len = Math.min(s1.length(),s2.length());
        while(index<len){
            if(s1.charAt(index)==s2.charAt(index)){
                index++;
            }
        }
        return s1.substring(0,index);
    }
}
