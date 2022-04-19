package com.whl.algo.算法分类.单调栈;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
输出: [-1,3,-1]
解释:
    对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
    对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
    对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
* 思路:哈希+单调栈
* */
public class 下一个更大元素 {
    public static Map<Integer,Integer> nextGreate(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack =new Stack<>();
        stack.push(nums[0]);
        for(int i=1;i<nums.length;i++){
            while (!stack.isEmpty() && nums[i]>stack.peek()){
               map.putIfAbsent(stack.pop(),nums[i]);
            }
            stack.push(nums[i]);
        }
        while (!stack.isEmpty()){
            map.putIfAbsent(stack.pop(),-1);
        }
        return map;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,4};
        Map map = nextGreate(nums);
        System.out.println(JSON.toJSONString(map));
    }
}
