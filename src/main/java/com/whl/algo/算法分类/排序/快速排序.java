package com.whl.algo.算法分类.排序;

import com.alibaba.fastjson.JSON;

/*
* https://leetcode.cn/problems/sort-an-array/solution/duo-chong-pai-xu-yi-wang-da-jin-kuai-pai-wgz4/
* 思路：先选择最左元素pivot临时存储，r--直到小于pivot填充到a[l]元素索引，否则l++直到大于pivot元素填充到刚才a[r],直到l==r，pivot填充该位置，递归调用左右两段继续重复步骤
*
* */
public class 快速排序 {

    public static void quickSort(int[] arr,int l,int r){
       if(l<r){
           int pos = partion(arr,l,r);
           quickSort(arr,l,pos-1);
           quickSort(arr,pos+1,r);
       }
    }

    //按边界分区排序，小于pivot放左边，大于pivot放右边,临时pivot变量
    public static int partion(int[] arr,int l,int r){
       int pivot = arr[l];
       while (l<r){
           while (l< r && arr[r]>pivot){//满足条件索引r--
               r--;
           }
           if(l<r){
            arr[l++]=arr[r];
           }
           while (l< r && arr[l]<pivot){//满足条件索引l++
               l++;
           }
           if(l<r){
               arr[r--]=arr[l];
           }
       }
       arr[l]=pivot;
       return l;
    }

    public static void main(String[] args) {
        int[] arr ={5,2,9,1,3,6};
//        partion(arr,0,arr.length-1);
        quickSort(arr,0,arr.length-1);
        System.out.println(JSON.toJSONString(arr));
    }
}
