package com.whl.algo.算法分类.数理;

/*
* 给定一个非负整数数组nums，nums 中一半整数是 奇数 ，一半整数是 偶数 。
* 对数组进行排序，以便当nums[i] 为奇数时，i也是 奇数 ；当nums[i]为偶数时， i 也是 偶数
* 思路一：两侧遍历
* 思路一：双指针
*
* */
public class 按奇偶排序数组II {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int i = 0;
        for (int x : nums) {
            if (x % 2 == 0) {
                ans[i] = x;
                i += 2;
            }
        }
        i = 1;
        for (int x : nums) {
            if (x % 2 == 1) {
                ans[i] = x;
                i += 2;
            }
        }
        return ans;
    }

}
