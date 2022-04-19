package com.whl.algo.算法分类.动归;

/*
* 输入: [1,12,-5,-6,50,3], k = 4
* 输出: 12.75
* 思路:滑动窗口 左边退出一个右边入一个
* 动态规划 dp[i]=max(dp[i-1],dp[i-1]+num[j]-nums[j-k])
* */
public class 最大连续子序平均数 {
    public static double maxAvg(int[] nums,int k){
        double max = Integer.MIN_VALUE;
        double sum = 0;
        for(int i=0;i<k;i++){
            sum+=nums[i];//K个sum
        }
        System.out.println(sum);
        for(int j=k;j<nums.length;j++){
            sum+=nums[j]-nums[j-k];
            System.out.println("sum:"+sum);
            max = Math.max(max,sum);
        }
        return (double) max/(double) k;
    }

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        double result = maxAvg(nums,4);
        System.out.println(result);
    }
}
