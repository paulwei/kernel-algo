package com.whl.algo.type.dp;

import java.util.Arrays;

public class IIntegerBreak {
    public static void main(String[] args) {
        int result = integerBreak(10);
        System.out.println(result);
    }
    public static int integerBreak(int n){
        int []dp=new int [n+1];
        Arrays.fill(dp, 1);
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i-1;j++){
                System.out.println(String.format("i:%s,j:%s",i,j));
                dp[i]=Math.max(dp[i],Math.max(j*dp[i-j],j*(i-j)));
            }
        }
        return dp[n];
    }
}
