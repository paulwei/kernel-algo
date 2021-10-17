package com.whl.algo.dg;


import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if(coins.length==0) return 0;
        if(amount<0) return -1;
        int[] dp =new int[amount+1];//因为最多只能为amount 都是一元
        Arrays.fill(dp, Integer.MAX_VALUE);//无穷大代表凑不齐
        dp[0]=0;
        for(int i=0;i<=amount;i++){ //凑0，1，2，...11元最少用多少枚硬币
            for(int j=0;j<coins.length;j++){//循环每种硬币再每种目标值情况下最少硬币
                if(amount<coins[j]) continue;
                if(i-coins[j]<0) continue;
                dp[i]=Math.min(dp[i], dp[i-coins[j]]+1);//凑与不凑当前硬币最少数量，如果不凑dp[i]上次最少数量，凑dp[i-coins[j]]最少数量+1
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

