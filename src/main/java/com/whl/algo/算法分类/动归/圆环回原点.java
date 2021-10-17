package com.whl.algo.算法分类.动归;

/*
* 0~9的环，从0出发，N步后能否走回0
* 一个环上有10个点,编号为0-9,从0点出发,每步可以顺时针到下一个点,也可以逆时针到上一个点,求:经过n步又回到0点有多少种不同的走法？
举例
* 输入: 2
* 输出: 2
* 解释：有2种方案。分别是0->1->0和0->9->0
* 如果n=1，则从0出发只能到1或者9，不可能回到0，共0种走法,奇数
* 如果n=2，则从0出发有4条路径:0->1->2, 0->1->0, 0->9->8, 0->9->0,其中有两条回到了0点，故一共有2种走法
* 如果n=4，则从0出发有4条路径:0->1->2->3->4, 0->1->2->1->0, 0->9->8, 0->9->0,其中有两条回到了0点，故一共有2种走法
* 状态定义: dp[i] [j] , 表示 走 i 步 回到 j 点有多少种走法
* 递推方程: 举例: 走n步到0的方案数=走n-1步到1的方案数+走n-1步到9的方案数, 所以方程为
* dp[i][j] = dp[i-1][(j-1+length)%length] + dp[i-1][(j+1)%length]
* 初始化: dp[0][0]=1
* 目标: dp[n][0]
* */
public class 圆环回原点 {
    public static int back2Ori(int n){
        int len=10;
        int dp[][] = new int[n+1][len];
        dp[0][0]=1;
        for(int i=1;i<=n;i++){//步数
            for(int j=0;j<len;j++){
                dp[i][j]=dp[i-1][(j-1+len)%len]+dp[i-1][(j+1)%len];//j==0容易越界,所以 j-1+len
            }
        }
        return dp[n][0];
    }

    public static void main(String[] args) {
       int result = back2Ori(4);
       System.out.println(result);
    }
}
