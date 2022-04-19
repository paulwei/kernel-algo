package com.whl.algo.算法分类.差分数组;

import com.alibaba.fastjson.JSON;

/*
* 如果连续数组1~9 第3到第5加2 {1,2,3,4,5,6,7,8,9}
* 思路: 通过前缀和,从第三个开始+2到第6 个-2 前缀和数组相加 {0,0,2,0,0,-2,0,0,0}
* */
public class 连续子数组加值 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int[] result = subAdd(nums,3-1,5-1);//索引从 0 开始
        System.out.println(JSON.toJSONString(result));
    }
    public static int[] subAdd(int[] nums,int from,int to){
         int[] diff =  {0,0,2,0,0,-2,0,0,0};
         int sumDiff =0 ;
         for(int i=0;i<diff.length;i++){
             sumDiff+=diff[i];
             nums[i]=nums[i]+sumDiff;
         }
         return nums;
    }
}
