package com.whl.algo.算法分类.数理;

/*
* 给定正整数n，找到若干个完全平方数（比如1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
* 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量
* 输入：n = 12
* 输出：3
* 解释：12 = 4 + 4 + 4
* */
public class 完全平方数 {
    public static int numSquares(int n) {
        int[] dp = new int[n + 1]; // 默认初始化值都为0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况就是每次+1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
            }
            System.out.println(String.format("dp[%s]:%s",i,dp[i]));

        }
        return dp[n];
    }

    public static void main(String[] args) {
     int result =  numSquares(12);
        System.out.println(result);
    }
}
