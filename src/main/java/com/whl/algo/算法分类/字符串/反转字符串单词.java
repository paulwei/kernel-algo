package com.whl.algo.算法分类.字符串;

/*
*
* 思路：空格分割字符串，双指针或者递归
* */
public class 反转字符串单词 {
    public static String reverse(String str){
      String[] arr =  str.split("\\s+");
      int n = arr.length-1;
      return recursive(arr,n);
    }
    public static String recursive(String[] arr,int end){
        if(end==0){ //递归出口
            return ""+arr[0];
        }
       return arr[end] +" "+ recursive(arr,end-1);

    }
    public static void main(String[] args) {
        String str ="abc def gh";
        String ans = reverse(str);
        System.out.println(ans);

    }
}
