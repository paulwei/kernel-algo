package com.whl.algo.算法分类.双指针;

/*
* 快慢指针 fast 与 fast-1 相同 fast++,不同 num[slow]=num[fast] slow++,fast++
*
*
* */
public class 删除重复子串 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
