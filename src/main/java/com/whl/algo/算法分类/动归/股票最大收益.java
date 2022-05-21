package com.whl.algo.算法分类.动归;

/*
*思路:差值最大
*
* */
public class 股票最大收益 {

    public static int maxProfit(int[] nums){
        Integer lowest = Integer.MAX_VALUE;
        Integer max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            lowest = Math.min(lowest,nums[i]);//买入最低值
            max = Math.max(max,nums[i]-lowest);//当前减去最低值差值最大值
        }
        return max;
    }

    public static void main(String[] args) {
        int []a = {7, 1, 5, 3, 6, 4};
        int result = maxProfit(a);//1入 6 出
        System.out.println(result);
    }
}
