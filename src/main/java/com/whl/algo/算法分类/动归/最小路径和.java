package com.whl.algo.算法分类.动归;

/*
* 假设我们有一个 m * n 的矩形 ：[[1,3,1],[1,5,1],[4,2,1]]
* 左上角到右下角的最小路径和，我们可以很容易看出就是 1-3-1-1-1 ，这一条路径，结果等于 7
* 思路:状态转移方程 dp[i][j] = min(dp[i-1][j],dp[i][j-1]) + grid[i][j]
* */
public class 最小路径和 {

    public static int minSumPath(int[][] nums){
        int m = nums.length;
        int n = nums[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = nums[0][0];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                if(i==0 && j==0){
                    dp[i][j] = nums[i][j];
                } else if(i==0 && j!=0){
                    dp[i][j]=dp[i][j-1]+nums[i][j];//前一个向上
                }else if(j==0 && i!=0){
                    dp[i][j]=dp[i-1][j]+nums[i][j];//前一个向左
                }else{
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+nums[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] nums = {{1,3,1},{1,5,1},{4,2,1}};
        int result = minSumPath(nums);
        System.out.println(result);
    }
}
