package com.whl.algo.算法分类.单调栈;

public class 商品折扣后的最终价格 {
    public int[] finalPrices(int[] prices) {
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[i] >= prices[j]){
                    prices[i]=prices[i]-prices[j];
                    break;
                }
            }
        }
        return prices;
    }
}
