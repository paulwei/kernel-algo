package com.whl.algo.算法分类.数理;

/*
*思路:贪心思想
* */
public class 跳跃游戏 {
    public static boolean canJump(int[] nums){
        int[] jump= new int[nums.length];
        for(int i=0;i<nums.length;i++){
            jump[i]=i+nums[i];//当前索引+跳最远距离=当前能到达最远距离
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
