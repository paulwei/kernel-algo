package com.whl.algo.算法分类.抽屉原理;

import java.util.Arrays;

/*
* 给定一个长度为 n 的整数数组 nums，数组中所有的数字都在 0∼n−1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
* 请找出数组中任意一个重复的数字。
*
* */
public class 重复数 {
    public static int duplicateInArray(int[] nums){
        int[] home=new int[nums.length];
        Arrays.fill(home,-1);
        for(int i=0;i<nums.length;i++){
            if(home[nums[i]]==-1){
                home[nums[i]]=nums[i];
            }else{
                return nums[i];
            }
        }
        return 0;
    }

    public static int duplicateInArray2(int[] nums){
        for(int i=0;i<nums.length;i++){
           while (nums[nums[i]]!=nums[i]){
               swap(nums[nums[i]],nums[i]);
           }
        }
        return 0;
    }

    public static void swap(int a,int b){

    }


    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,3,3};
        int result = duplicateInArray2(nums);
        System.out.println(result);
    }
}
