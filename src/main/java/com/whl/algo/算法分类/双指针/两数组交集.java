package com.whl.algo.算法分类.双指针;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/*
* 双指针
* */
public class 两数组交集 {

    public static void main(String[] args) {
       int[] nums1 = {4,9,5} ;
       int[] nums2 = {9,4,9,8,4};
       int[] result = insect(nums1,nums2);
        System.out.println(JSON.toJSONString(result));
    }

    public static int[] insect(int[] nums1,int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0,k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                nums1[k]=nums1[i];
                i++;j++;k++;
            }
        }
      return  Arrays.copyOfRange(nums1,0,k);
    }
}
