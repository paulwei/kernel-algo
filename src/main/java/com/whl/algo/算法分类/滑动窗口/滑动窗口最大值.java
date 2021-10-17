package com.whl.algo.算法分类.滑动窗口;

import com.alibaba.fastjson.JSON;

import java.util.Deque;
import java.util.LinkedList;

/*
* 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。返回滑动窗口中的最大值
* 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
* 输出: [3,3,5,5,6,7]
* 思路:双指针
*
* */
public class 滑动窗口最大值 {

    public static int[] maxSlidingWindow(int[] nums,int k){
        int n = nums.length;
        int[] ans = new int[n-k+1];
        for(int i=0;i<n-k+1;i++){
            int max = Integer.MIN_VALUE;
            //找到每一个滑动窗口的最大值
            for(int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            ans[i]=max;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] ans = maxSlidingWindow(nums,3);
        System.out.println(JSON.toJSONString(ans));
    }
}
