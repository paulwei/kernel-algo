package com.whl.algo.算法分类.双指针;

/*
* 接雨水问题
* 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
* 输出：6
* 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
* 思路:下标 i处能储存雨水量 min(leftMax[i],rightMax[i])-height[i]
*
* */
public class 接雨水 {

    //动态规划 min(leftMax[i],rightMax[i])-height[i]
    public static int waterTrap(int[] height){
        int ans = 0;
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(leftMax[i-1],height[i]);
        }
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1],height[i]);
        }
        for(int i=0;i<n-1;i++){//最右边接不住水
            ans+=Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return ans;
    }



    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = waterTrap(nums);
        System.out.println(result);
    }
}
