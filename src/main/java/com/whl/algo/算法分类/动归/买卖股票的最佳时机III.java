package com.whl.algo.算法分类.动归;
/*
*  给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
*  设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
*  注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
* 输入：prices = [3,3,5,0,0,3,1,4]
* 输出：6
* 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
* 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。

*
* */
public class 买卖股票的最佳时机III {
    //那么对于边界条件，我们考虑第 i=0i=0 天时的四个状态：\textit{buy}_1buy
    //1
    //​
    //  即为以 \textit{prices}[0]prices[0] 的价格买入股票，因此 \textit{buy}_1=-\textit{prices}[0]buy
    //1
    //​
    // =−prices[0]；\textit{sell}_1sell
    //1
    //​
    //  即为在同一天买入并且卖出，因此 \textit{sell}_1=0sell
    //1
    //​
    // =0；\textit{buy}_2buy
    //2
    //​
    //  即为在同一天买入并且卖出后再以 \textit{prices}[0]prices[0] 的价格买入股票，因此 \textit{buy}_2=-\textit{prices}[0]buy
    //2
    //​
    // =−prices[0]；同理可得 \textit{sell}_2=0sell
    //2
    //​
    // =0。我们将这四个状态作为边界条件，从 i=1i=1 开始进行动态规划，即可得到答案。
    //
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

    public int maxProfit2(int[] prices) {
        int len=prices.length;
        if(len<=1){
            return 0;
        }
        int[] dp1=new int[len];
        int[] dp2=new int[len];
        int pre=0;
        for(int i=1;i<len;i++)
        {
            pre=Math.max(pre+prices[i]-prices[i-1],prices[i]-prices[i-1]);
            dp1[i]=Math.max(pre,dp1[i-1]);
        }
        pre=0;
        for(int i=len-1;i>0;i--)
        {
            pre=Math.max(pre+prices[i]-prices[i-1],prices[i]-prices[i-1]);
            dp2[i-1]=Math.max(pre,dp2[i]);
        }
        int max=0;
        for (int i = 0; i <len-1; i++) {
            max=Math.max(max,dp1[i]+dp2[i+1]);
        }
        return Math.max(max,dp1[len-1]);

    }

}
