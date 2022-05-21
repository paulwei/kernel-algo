package com.whl.algo.算法分类.数理;
/*
* 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2]
* 输入：nums = [4,5,6,7,0,1,2], target = 0 局部有序
* 输出：4
* 要求  O(log n)
* 思路：二分法拆分后，判断最左边和最右边大小,先找到旋转点，然后看在哪段
* */
public class 搜索旋转排序数组 {
    public static int search(int[] arr,int target){
        int pivot = rotation(arr);
        int low = 0; int high= arr.length-1;
        if(target>=arr[0] && target<=arr[pivot] ){
            high=pivot;
        }else{
            low=pivot+1;
        }
        while (low<high){
            int mid =  low + (high-low)/2;
            if(target==arr[mid]){
                return mid;
            }
            if(target<arr[mid]){
                high=mid;
            }else{
                low=mid;
            }
        }
        return -1;
    }

    public static int rotation(int[] arr){
        int low = 0;int high = arr.length-1;
        while (low<high){
            int mid =  low + (high-low)/2;
            System.out.println("mid:"+arr[mid]+",low:"+arr[low]+",high:"+arr[high]);
            if(arr[low]<arr[mid]){
                low=mid;
            }else{
                high=mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
//        int[] arr = {2 ,3 ,4 ,5 ,6 ,7, 1};
        int[] arr = {4,5,6,7,0,1,2};
//        int pivot = rotation(arr);
        int ans = search(arr,0);
        System.out.println(ans);
    }
}
