package com.whl.algo.算法分类.动归;

import java.util.*;

/*
* 输入:[1,9,2,5,7,3,4,6,8,0]
* 输出 [3,4,6,8]
* 思路:动态规划
* dp[i]=dp[i-1]+1
* */
public class 最大连续上升子序列长度 {

    public static int maxLen(int[] nums){
        int[] dp = new int[nums.length];
        int res=Integer.MIN_VALUE ;
        dp[0]=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+1;
            }else{
                dp[i]=1;//下降子序列置为 1
            }
            res = Math.max(res,dp[i]);//后续可能没有最大连续最大子序列
        }
        return res;
    }

    public static List<Integer> maxLenArray(int[] nums){
        List<List<Integer>> res = new LinkedList();
        List<Integer> list = new LinkedList<>();
        list.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                list.add(nums[i]);
            }else{
                list =  new LinkedList<>();
                list.add(nums[i]);
            }
            res.add(list);
        }
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.size()-o1.size();
            }
        });

        return res.get(0);
    }

    public static void main(String[] args) {
        int[] nums ={1,9,2,5,7,3,4,6,8,0};
        int result = maxLen(nums);
        System.out.println(result);
        List<Integer> result2 = maxLenArray(nums);
        System.out.println(result2);
    }
}
