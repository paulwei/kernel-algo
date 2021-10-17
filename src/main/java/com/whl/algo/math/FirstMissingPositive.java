package com.whl.algo.math;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {

        // 缺失数一定出现在 [1, N+1] 范围内
        // 取得数组长度为 N
        // 第一次遍历，将所有非正数修改为 N+1
        int N = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = N + 1;
            }
        }

        // 第二次遍历，打标记，将元素属于 1 ~ N 范围内的数反转为负数
        for (int n : nums) {
            if (Math.abs(n) <= N) {
                nums[Math.abs(n) - 1] = - Math.abs(nums[Math.abs(n) - 1]) ;
            }
        }

        // 第三次遍历，元素大于0，则缺失数为 下标 + 1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i  + 1;
            }
        }

        return N + 1;
    }

}
