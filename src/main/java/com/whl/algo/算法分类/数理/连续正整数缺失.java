package com.whl.algo.算法分类.数理;
import com.alibaba.fastjson.JSON;
/*
* 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
* 输入：nums = [1,2,0]
* 输出：3
 *思路:连续正整数【可以抽屉打标法】
* */
public class 连续正整数缺失 {
    public static void main(String[] args) {
        int[] nums = {9,15,6,4,2,3,5,8,1};
        int result = firstMissingPositive(nums);
        System.out.println(result);
    }

    public static int firstMissingPositive(int[] nums) {

        // 缺失数一定出现在 [1, N+1] 范围内
        // 取得数组长度为 N
        // 第一次遍历，将所有非正数修改为 N+1
        int N = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = N + 1;
            }
        }

        // 第二次遍历，打标记，将元素属于 1 ~ N 范围内的数反转为负数
        for (int n : nums) {
            if (Math.abs(n) <= N) {//所有小于等于N负数,每个数对应坐标置为对应负数,缺失数对应坐标不会置为负数
                nums[Math.abs(n) - 1] = - Math.abs(nums[Math.abs(n) - 1]) ;
                System.out.println("n:"+n);
            }
        }
        System.out.println(JSON.toJSONString(nums));//[-9,-15,-6,-4,-2,-3,-5,7,-1]

        // 第三次遍历，元素大于0，则缺失数为 下标 + 1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i  + 1;
            }
        }

        return N + 1;
    }

}
