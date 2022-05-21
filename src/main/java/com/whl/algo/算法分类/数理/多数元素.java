package com.whl.algo.算法分类.数理;

import java.util.Arrays;

/*
* 多数元素表示在一个数组中出现次数最多，并且出现次数 > 数组总长度的一半的元素。例如数组a = {1,7,5,5,5,5,5,4}，数组总长度为8，5在其中出现了5次，大于8/2=4次，因此5是多数元素。
* 而在数组b = {1,2,5,5,5,9,7,6,4}，数组总长度为9，5虽然同样是出现次数最多的元素，但他的出现次数只有3次，因而不能算作多数元素。
* */
public class 多数元素 {
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
      int[] arr= {2,2,1,1,1,2,2};
      int ans = majorityElement(arr);
      System.out.println(ans);
    }
}
