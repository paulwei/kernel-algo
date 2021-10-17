package com.whl.algo.digit;

/**
 * Created by PAUL on 2020-9-4.
 */
public class StockMaxProfit {
    public static void main(String[] args) {
        int []a = {7, 1, 5, 3, 6, 4};
        int result = maxProfit(a);
        System.out.println(result);
    }

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int maxProfit = 0;
        int lowest = Integer.MAX_VALUE;
        for (int v : prices) {
            lowest = Math.min(v, lowest);
            int diff = v - lowest;
            System.out.println(String.format("lowest:%s,v:%s diff:%s",lowest,v,diff));
            maxProfit = Math.max(maxProfit, diff);
        }
        return maxProfit;
    }
}
