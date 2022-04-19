package com.whl.algo.算法分类.尺取法;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/*
* 题目的意思是给你一个n和s，然后给出n个数，求这n个数中和大于等于s的最小连续序列。
* 思路:双指针,尺取法,左右两指针,当右指针右移到
* 思路2: 双端队列,小于等于K一直入,如果大于K头端出,记录最短的头和尾索引
* shortest-subarray-with-sum-at-least-k
* */
public class 和大于K最小连续子序列 {
    public static int[] getSumGreateLestSub(int[] nums,int s){
        int left = 0;int right = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int minL = 0;
        int minR = 0;
        while (left<nums.length && right<nums.length){
            if(sum<s){
                sum = sum + nums[right++];
            }else{
                sum = sum-nums[left++];
                if(sum>s && minLen>(right-left+1)){
                    minLen = right-left+1;
                    minL = left;
                    minR = right;
                }
                System.out.println("left:"+left+",right:"+right+",sum:"+sum+",minLen:"+minLen+",minL:"+minL+",minR:"+minR);
            }

        }
        return Arrays.copyOfRange(nums,minL,minR);
    }

    public static void main(String[] args) {
        int[] nums = {2,-1,2,2,-1,4,3,-5};
        int k = 5;
        int[] result = getSumGreateLestSub(nums,k);
        System.out.println(JSON.toJSONString(result));
    }
}
