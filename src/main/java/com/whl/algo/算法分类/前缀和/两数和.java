package com.whl.algo.算法分类.前缀和;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* Hash 算法,以元素为 key,值为索引
* */
public class 两数和 {

    public static List<Integer[]> twoSum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        List<Integer[]> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(target==nums[i]){
                Integer[] ele = new Integer[2];
                ele[0]=i;
                ele[1]=i;
                list.add(ele);
                continue;
            }
           int gap = target-nums[i];
           Integer index = map.get(gap);
           if(index!=null && i!=index){
                Integer[] ele = new Integer[2];
                ele[0]=i;
                ele[1]=index;
                list.add(ele);
           }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
//        int[] nums={1,1,1};
        List<Integer[]> result = twoSum(nums,3);
        System.out.println(JSON.toJSONString(result));
        System.out.println(result.size());
    }
}
