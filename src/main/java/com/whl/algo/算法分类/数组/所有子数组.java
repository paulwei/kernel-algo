package com.whl.algo.算法分类.数组;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class 所有子数组 {
    /*暴力解法*/
    public static int allSubArr(int[] nums){
        int max = Integer.MIN_VALUE;
        int len = nums.length;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                int[] tmp =  Arrays.copyOfRange(nums,i,j+1);
                System.out.println(String.format("i:%s,j:%s,tmp:%s",i,j, JSON.toJSONString(tmp)));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {6,2,1};
        allSubArr(nums);
    }
}
