package com.whl.algo.算法分类.单调栈;

import java.util.Stack;

/*
输入：prices = [8,4,6,2,3]
输出：[4,2,4,2,3]
解释：
商品 0 的价格为 price[0]=8 ，你将得到 prices[1]=4 的折扣，所以最终价格为 8 - 4 = 4 。
商品 1 的价格为 price[1]=4 ，你将得到 prices[3]=2 的折扣，所以最终价格为 4 - 2 = 2 。
商品 2 的价格为 price[2]=6 ，你将得到 prices[3]=2 的折扣，所以最终价格为 6 - 2 = 4 。
商品 3 和 4 都没有折扣。
示例 2：

* 题目意思就是对于数组中的每一个元素，找出它之后第一个小于等于它的元素，并求出它俩之差。
* 维护一个单调递增序列，栈中存放下标
* */
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

    public int[] finalPrices2(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<prices.length;i++){
            if(!stack.isEmpty() && stack.peek()<prices[i]){
                Integer pre = stack.pop();
                prices[pre]=prices[pre]-prices[i];
            }
            stack.push(i);
        }
        return prices;
    }


    public static void main(String[] args) {
        System.out.println("a");
    }
}
