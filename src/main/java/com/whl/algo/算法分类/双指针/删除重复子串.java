package com.whl.algo.算法分类.双指针;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/*
* 快慢指针 fast 与 fast-1 相同 fast++,不同 num[slow]=num[fast] slow++,fast++
*
*
* */
public class 删除重复子串 {
    public  static int removeDuplicate1(int[] nums) {
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
    //思路双指针i,j不同时候同时后移,如果相同则只有j++
    public static int removeDuplicate2(int[] nums){
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[i]){
                nums[++i]=nums[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
//        int[] nums = {1,1,1,2,2,3,3};
        int i= removeDuplicate2(nums);
        System.out.println(JSON.toJSONString(Arrays.copyOfRange(nums,0,i+1)));
    }
}
