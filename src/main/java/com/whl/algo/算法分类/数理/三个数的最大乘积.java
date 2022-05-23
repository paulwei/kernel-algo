package com.whl.algo.算法分类.数理;

import java.util.Arrays;

/*
*
*
* 思路：先排序，当乘积最大时，三个数的可能情况有两种，一是选数组中最大的三个数，二是选数组中最大的一个数与最小的两个数。对于这两种情况分别计算乘积，返回最大乘积。
* 如果数组中至少有两个负数，则当乘积最大时，最大乘积一定是非负数。可能选三个最大的非负数，也可能选一个最大的非负数与两个最小的负数（即两个绝对值最大的负数）。
* 如果数组中只有一个负数，则任意三个数中至少有两个非负数，当乘积最大时，一定是选数组中的最大三个数
*
* */
public class 三个数的最大乘积 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }
}
