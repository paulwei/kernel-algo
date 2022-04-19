package com.whl.algo.算法分类.数理;

/*
* 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
* 输入: [4,1,2,1,2]
* 输出: 4
* 思路:异或运算,任何数和 0 异或就等于任何数,相同数异或等于 0
* */
public class 只出现一次的数字 {


    public static int getSingleNum(int[] nums){
        int single = 0;
        for(int i=0;i<nums.length;i++){
            single^=nums[i];
            System.out.println(i+":"+single);
        }
        return single;
    }

    public static void main(String[] args) {
       int[] nums ={3,5,3,6,6};
       int result = getSingleNum(nums);
        System.out.println(result);
    }
}
