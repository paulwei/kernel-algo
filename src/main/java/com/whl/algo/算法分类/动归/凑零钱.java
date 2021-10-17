package com.whl.algo.算法分类.动归;

import java.util.Arrays;

public class 凑零钱 {
    public static int coinChange(int[] nums,int amount){
       int[] dp = new int[amount+1];//dp[i] i元需要凑足需要最少硬币数
        Arrays.fill(dp, Integer.MAX_VALUE);//无穷大代表凑不齐
       int[] coins = {1,2,5};
       dp[0]=0;
       for(int i=0;i<=amount;i++){
           for(int j=0;j<coins.length;j++){
               if(amount<coins[j]) continue;//凑钱比硬币少
               if(i-coins[j]<0) continue;//不够硬币凑

               dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);//凑与不凑当前硬币最少数量，如果不凑dp[i]上次最少数量，凑dp[i-coins[j]]最少数量+1
           }
       }
       return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int target  = 11;
        System.out.println(coinChange(coins,target));
    }
}
