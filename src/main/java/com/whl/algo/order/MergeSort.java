package com.whl.algo.order;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class MergeSort {
    public static void main(String []args){
        int []arr = {7,9,4,8};
        sort(arr);
//        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
//        merge(arr,0,1,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }



    public static void sort(int []arr){
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr,0,arr.length-1,temp);
    }
    private static void sort(int[] arr,int left,int right,int []temp){
        if(left<right){
            int mid = (left+right)/2;

            System.out.println(String.format("sort1 left:%s  mid:%s  right:%s ",left,mid,right,JSON.toJSONString(temp)));

            sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序

//            System.out.println(String.format("sort2 left:%s  mid:%s  right:%s ",left,mid,right,JSON.toJSONString(temp)));

//            System.out.println(String.format("high left:%s  right:%s  ",mid+1,right, JSON.toJSONString(temp)));
            sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
            System.out.println("**************************************");
        }
    }
    //合并两个有序数组，双指针从前往后，谁小谁放前面
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){

        int i = left;//左序列指针
        int j = mid+1;//右序列指针
//        System.out.println(String.format("merge begin i:%s mid:%s j:%s  right:%s  arr:%s temp:%s",i,mid,j,right,JSON.toJSONString(arr),JSON.toJSONString(temp)));

        int t = 0;//临时数组双指针i,j
        while (i<=mid && j<=right){
            System.out.println("111");
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            System.out.println("222");
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            System.out.println("333");
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            System.out.println("444");
            arr[left++] = temp[t++];
        }
        System.out.println(String.format("merge end i:%s  j:%s  right:%s  arr:%s temp:%s",i,j,right,JSON.toJSONString(arr),JSON.toJSONString(temp)));

    }
}
