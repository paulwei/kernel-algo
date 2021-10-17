package com.whl.algo.dg;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray(nums);
        System.out.println(result);
    }

    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);//f(i)=max{f(i−1)+nums[i],nums[i]}动态规划
            maxAns = Math.max(maxAns, pre);//枚举和前一个比较哪个大
            System.out.println(String.format("pre:%s maxAns:%s",pre,maxAns));
        }
        return maxAns;
    }

}
