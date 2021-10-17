package com.whl.algo.算法分类.双指针;

public class 寻找峰值 {
    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (; left < right; ) {
            int mid = (left+right)/ 2;
//            System.out.println(mid);
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,8,4};
       int result = findPeakElement(nums);
        System.out.println(result);
    }

}
