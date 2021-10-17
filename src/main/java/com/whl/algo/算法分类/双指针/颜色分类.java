package com.whl.algo.算法分类.双指针;

import com.alibaba.fastjson.JSON;

/*
* 荷兰国旗问题
* 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
* 输入：nums = [2,0,2,1,1,0]
* 输出：[0,0,1,1,2,2]
*
* */
public class 颜色分类 {
    public static void sortColors(int[] nums){
        int i=0;
        int left = -1;
        int right = nums.length;
        while (i<right){
            if(nums[i]==2){
                swap(nums,i,right-1);//如果当前为 2 就和 right-1 交换,right--
                right--;
            }else if(nums[i]==0){       //如果当前为 0 就和 left+1 交换,left++
                swap(nums,i,left+1);
                left++;
                i++;
            }else {
                i++;
            }
        }
    }

    public static void swap(int[] nums ,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(JSON.toJSONString(nums));
    }

}
