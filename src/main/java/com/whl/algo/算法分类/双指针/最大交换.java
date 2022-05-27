package com.whl.algo.算法分类.双指针;

/*
* 示例 1 :
  输入: 2736  5278
  输出: 7236  8527
  解释: 交换数字2和数字7。
* 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
* 思路:找后边最大一个数字交换
* 逆序求最大数的下标
* 正序找到第一个最大的不等于自己的，交换
 * */
public class 最大交换 {

    public static int swapMax(int num){
        char[] charArray = String.valueOf(num).toCharArray();
        int n = charArray.length;
        long max = Long.MIN_VALUE;
        int max_index= -1;
        for(int i=n-1;i>0;i--){
            max = Math.max(max,charArray[i]);
            if(charArray[i]>max){
                max=charArray[i];
                max_index = i;
            }
        }
        //max最大数索引index1
        for(int i=0;i<n;i++){
            if(charArray[i]<max){
                swap(charArray,max_index,i);//8275
            }
        }
        return Integer.parseInt(new String(charArray));
    }

    private static void swap(char[] charArray, int index1, int index2) {
        char temp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = temp;
    }

}
