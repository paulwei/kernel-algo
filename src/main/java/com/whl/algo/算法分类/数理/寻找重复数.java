package com.whl.algo.算法分类.数理;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 寻找重复数 {

    public static int findDuplicate(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return nums[i];
            }else{
                set.add(nums[i]);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums={1,3,4,2,2};
        int result = findDuplicate(nums);
        System.out.println(result);
    }
}
