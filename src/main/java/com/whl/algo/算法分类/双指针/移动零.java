package com.whl.algo.算法分类.双指针;

import com.alibaba.fastjson.JSON;

/*
* 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
* 输入: [0,1,0,3,12]
* 输出: [1,3,12,0,0]
* 思路:快慢指针,快指针遇到 非 0 向前移,最后补0
* */
public class 移动零 {

    public static void moveZeros(int[] nums){
        int slow =0;
        for(int fast=0;fast<nums.length;fast++ ){
            System.out.println(fast+":"+slow);
            if(nums[fast]!=0){
                nums[slow++]=nums[fast];//本身赋值本身也没错,slow 先使用
            }
        }
        for(int i=slow;i<nums.length;i++){
            nums[i]=0;
        }
    }

    public static void main(String[] args) {
            int[] nums = {0,1,0,0,3,12};
            moveZeros(nums);
        System.out.println(JSON.toJSONString(nums));
    }
}
