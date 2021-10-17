package com.whl.algo.算法分类.动归;

/*
* 给你一根长度为n的绳子，每段整数,求乘积最大值
* 路 math.max(pd[i]*pd[n-i])
* n<4 最大乘积就是自身,大于 4 分解由 4 下
* */
public class 剪绳子 {
    public static int maxProduct(int n){
        int[] product=new int[n+1];
        product[0]=0;
        product[1]=1;
        product[2]=2;
        product[3]=3;
        for(int i =4;i<=n;i++){
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int curProduct = product[j] * product[i - j];
                max = Math.max(curProduct, max);
            }
            product[i] = max;
        }
        return product[n];
    }

    public static void main(String[] args) {
        int result = maxProduct(8);
        System.out.println(result);
    }
}
