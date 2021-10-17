package com.whl.algo.算法分类.前缀和;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/*
* 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
输入：nums = [1,2,3], k = 3
输出：2
hash可以优化剪枝
 * */
public class 和为K的子数组 {


    //前缀和
    public static int subArraySum(int[] nums,int target){
        int ans =0 ;
        int[] preSum = new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            preSum[i+1]=preSum[i]+nums[i];
        }
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<preSum.length;j++){
                if(preSum[j]-preSum[i]==target){
                    ans++;
                }
            }
        }
        return ans;
    }
    //前缀和+hash
    public static int subArraySum2(int[] nums,int target){
        int ans =0 ;
        int sumi=0;
        Map<Integer,Integer> map = new HashMap<>();//<sum[i],次数> map：前缀和 -> 该前缀和出现的次数
        map.put(0,1);//为以下 sumj 作为 key
        for(int i=0;i<nums.length;i++){
           sumi+=nums[i];
           Integer sumj= sumi-target;//如果 sumj==0当前元素
           if(map.containsKey(sumj)){//代表存在这样元素
              ans+=map.getOrDefault(sumj,0);
           }
           map.put(sumi,map.getOrDefault(sumi,0)+1);
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] nums={1,2,3};
//        int[] nums={1,1,1};
        int result = subArraySum2(nums,3);
        System.out.println(result);
    }
}
