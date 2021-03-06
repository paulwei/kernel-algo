package com.whl.algo.digit;

/**
 * Created by PAUL on 2020-9-4.
 */
public class FindGreatestSumOfSubArray {
    public static void main(String[] args) {
        int[] arrys  = {6, -5, -3, 7, -15, 1, 2, 2};
        int result = findGreatestSumOfSubArray(arrys);
        System.out.println(result);
    }
    public static int findGreatestSumOfSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int greatestSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : nums) {
            sum = sum <= 0 ? val : sum + val;
            greatestSum = Math.max(greatestSum, sum);
        }
        return greatestSum;
    }
}
