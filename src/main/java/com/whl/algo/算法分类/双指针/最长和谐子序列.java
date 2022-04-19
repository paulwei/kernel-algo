package com.whl.algo.算法分类.双指针;

import java.util.Arrays;

/*
* 双指针也是暴力迭代
* 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
* 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。相对位置不变
* 输入：nums = [1,3,2,2,5,2,3,7]
* 输出：5
* 解释：最长的和谐子序列是 [3,2,2,2,3]
* 思路:先排序,然后计算 i,j双指针移动,如果不等于 1,从上次最后索引处开始
* */
public class 最长和谐子序列 {
    public static void main(String[] args) {
        int[] nums = {1,3,2,2,5,2,3,7};
        int result = findLHS(nums);
        System.out.println(result);
    }
    public static int findLHS(int[] nums){
        Arrays.sort(nums);
        int startIndex = 0;
        int endIndex = 0;
        int max = 0;
        int lastDiffIndex = 1;
        while(endIndex<nums.length){
            int start = nums[startIndex];
            int end = nums[endIndex];
            if(end - start == 0){
                endIndex++;
            }else if(end - start == 1){
                if(nums[lastDiffIndex] != end){
                    lastDiffIndex = endIndex;
                }
                max = Math.max(max, endIndex - startIndex + 1);
                endIndex++;
            }else{
                startIndex = lastDiffIndex;
                lastDiffIndex = endIndex;
            }
        }
        return max;
    }
}
