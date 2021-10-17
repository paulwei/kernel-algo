package com.whl.algo.dg;

/*
* 爬楼梯
* */
public class ClimStair {

    public int climbStairs(int n) {
        // 递归终止条件
        if(n == 1) return 1;
        if(n == 2) return 2;

        // 当前递归层的逻辑处理 加法
        // 进入下一层递归 climbStairs(n - 1) 和 climbStairs(n - 2)
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

}
