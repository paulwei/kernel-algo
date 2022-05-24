package com.whl.algo.算法分类.二分查找;

import com.alibaba.fastjson.JSON;

/*
* 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
* 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
* 输入：nums = [5,7,7,8,8,10], target = 8
* 输出：[3,4]
* 思路：二分法,先找起始位置，再循环一遍再找结尾位置
* */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public static int[] search(int[] arr,int target){
        int low = 0;
        int high = arr.length-1;
        while (low<high){
            int mid = (high-low)/2 + low;
            if(target<=arr[mid]){//先查找左边界位置
                high=mid;
            }else{
                low=mid+1;
            }
        }
        if(arr[high]!=target){
            return new int[]{-1,-1};
        }
        int L=high;
        System.out.println("L:"+L);
        low = 0;
        high = arr.length-1;
        while (low<high){
            int mid = (high+low+1)/2;//尽量向右位置
            if(target>=arr[mid]){//再查找右边界位置
                low=mid;
            }else{
                high=mid-1;
            }
        }
        int R = low;
        System.out.println("R:"+R);
        return new int[]{L,R};
    }

    public static void main(String[] args) {
       int[] arr = {5,7,7,8,8,10};
       int[] ans = search(arr,8);
       System.out.println(JSON.toJSONString(ans));
    }
}
