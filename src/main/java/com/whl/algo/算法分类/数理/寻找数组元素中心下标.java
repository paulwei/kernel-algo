package com.whl.algo.算法分类.数理;

import java.util.Arrays;

/*
* 输入：nums = [1, 7, 3, 6, 5, 6]
输出：3
解释：
中心下标是 3 。
左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
思路:所有和 sum, sum-num[i]=h
*
*
* */
public class 寻找数组元素中心下标 {
    public static int findMid(int[] nums){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        System.out.println(sum);
        int curtotal = 0;
        for(int i=0;i<nums.length;i++){
            curtotal+=nums[i];
            System.out.println(String.format("curtotal:%s,i:%s",curtotal,i));
           if(sum-nums[i]==2*(curtotal-nums[i])){//都减去当前元素
                return i;
           }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        int result = findMid(nums);
        System.out.println(result);
    }
}
