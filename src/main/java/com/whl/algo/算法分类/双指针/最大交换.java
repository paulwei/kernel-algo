package com.whl.algo.算法分类.双指针;

import java.util.Arrays;
import java.util.Collection;

/*
* 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
* 思路:找后边最大一个数字交换
 * */
public class 最大交换 {

    public static int swapMax(int num){
        char[] charArray = String.valueOf(num).toCharArray();

        for(int i=0;i<charArray.length;i++){
            int j=i+1;
            while (j<charArray.length){

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
