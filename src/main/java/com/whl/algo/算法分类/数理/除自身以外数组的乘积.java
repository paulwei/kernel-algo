package com.whl.algo.算法分类.数理;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/*
*
* 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。不准用除法
* 思路：p[i]=s[i-1]*s[i+1] 前缀积 再乘以逆序后缀积
* 输入: nums = [1,2,3,4]
* 输出: [24,12,8,6]
* */
public class 除自身以外数组的乘积 {
       public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[nums.length];
        Arrays.fill(ans,1);
        for (int i = 1; i < n; i ++ ) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
           System.out.println(JSON.toJSONString(ans));
        for (int i = n - 1, s = 1; i >= 0; i -- ) {
            ans[i] *= s;
            s *= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
       int[] nums = {1,2,3,4};
       int[] ans = productExceptSelf(nums);
       System.out.println(JSON.toJSONString(ans));
    }


}
