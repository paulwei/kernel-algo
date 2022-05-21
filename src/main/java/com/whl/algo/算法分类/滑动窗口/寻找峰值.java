package com.whl.algo.算法分类.滑动窗口;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/*
 * 思路 滑动窗口三个，arr[i] > arr[i-1] && arr[i]>arr[i+1]峰值
 * */

public class 寻找峰值 {

    public static List<Integer> findPeakElement(int[] arr){
        List<Integer> ans = new ArrayList<>();
        int i=1;
        while (i<arr.length-1){
            if(arr[i] > arr[i-1] && arr[i]>arr[i+1]){
                ans.add(i);
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
      int[] nums = {1,2,1,3,5,6,4};
        List<Integer> ans  =  findPeakElement(nums);
        System.out.println(JSON.toJSONString(ans));
    }
}
