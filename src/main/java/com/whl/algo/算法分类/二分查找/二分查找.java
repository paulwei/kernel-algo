package com.whl.algo.算法分类.二分查找;

import java.util.Arrays;

public class 二分查找 {

//    public static void main(String[] args) {
//        int[] nums = {3,7,4,8,6,10};
////        for(int i=5;i>=0;i--){
////            nums[i]=i;
////        }
//        int result = binsearchByNoOrder(nums,8);
//        System.out.println(result);
//    }

    //有序二分查找
    public static int binsearchByOrder(int[] nums,int target){
        int left =0;
        int right= nums.length-1;
        while (left<right){
            int mid = (left+right+1)/2;
//            System.out.println(mid);
            if(target < nums[mid]){
                right=mid-1;
            }else{
                left=mid;
            }
        }
        if(nums[left]==target){
            return left;
        }
        return -1;
    }

    //无序
    public static int binarySearch(Integer[] arr, int left, int right, Integer key) {
        if(left < right) {
            int partition = partition(arr, left, right);
            if(key < arr[partition]) {
                return binarySearch(arr, left, partition - 1, key);
            } else if (key > arr[partition]) {
                return binarySearch(arr, partition + 1, right, key);
            } else {
                return partition;
            }
        }
        return 0;
    }

    public static int partition(Integer[] arr, int left, int right) {
        int temp = left - 1;
        for(int i = left; i < right; i++) {//最 arr[right]作为 pivot
            if(arr[i] < arr[right]) {//比 arr[right]小尽量往前移,比 a[right]大相当于后移交换
                temp++;
                swap(arr, temp, i);
            }
        }
        swap(arr, temp + 1, right);//temp+1左侧小于 a[right],右侧大于 a[right],将 temp+1与 a[right]交换就插入合适位置
        return temp + 1;
    }

    /**
     * 交换数组元素
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(Integer[] arr, int i, int j) {
        Integer temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        Integer[] arr = {8, 6, 2, 3, 2, 9, 1, 5, 7};
        System.out.println(binarySearch(arr, 0 ,arr.length - 1, 2));
        System.out.println(Arrays.asList(arr));

    }

}
