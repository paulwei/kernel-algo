package com.whl.algo.算法分类.双指针;

import java.util.Arrays;

/*
* 反转第 K个之前字符串
* 思路:首位双指针交换
* */
public class 反转字符串 {

    public static void main(String[] args) {
        reverseString("abcdefg");
    }

    public static void reverseString(String s){
       char[] array = s.toCharArray();
       int i=0;
       int j = array.length-1;
       while (i<j){
           swap(array,i++,j--);
       }
        System.out.println(Arrays.toString(array));
    }

    public static void swap(char[] array,int i,int j){
        char temp = array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
