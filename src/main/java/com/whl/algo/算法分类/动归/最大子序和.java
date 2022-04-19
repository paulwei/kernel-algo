package com.whl.algo.算法分类.动归;

/*
* {6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(
* 思路:动态规划
* Math.max(max + array[i], array[i]),如果比array[i]小从该 i再开始,只要 max不为负数即可
* */
public class 最大子序和 {
    public static int maxSum(int[] nums){
        int max = Integer.MIN_VALUE;
        int res = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max+nums[i],nums[i]);
            System.out.println(String.format("i:%s,max:%s",i,max));
            res = Math.max(res,max);//可能后序相加还没之前最大值
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {6,-3,-2,7,-15,1,2,2};
        int result = maxSum(nums);

        System.out.println(result);
    }

}
