package com.whl.algo.算法分类.数理;

/*
*
* */
public class 跳跃游戏 {
    public static boolean canJump(int[] nums){
        int[] jump= new int[nums.length];
        for(int i=0;i<nums.length;i++){
            jump[i]=i+nums[i];
        }
        int maxJump=jump[0];
        int index=0;
        while (index<nums.length && index<=maxJump){
            maxJump = Math.max(maxJump,jump[index]);
            index++;
        }
        if(index==nums.length){
            return true;
        }
        return false;
    }
}
