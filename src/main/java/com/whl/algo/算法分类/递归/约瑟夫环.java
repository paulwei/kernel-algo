package com.whl.algo.算法分类.递归;

/*
* N个人围成一圈，第一个人从1开始报数，报M的将被杀掉，下一个人接着从1开始报。如此反复，最后剩下一个，求最后的胜利者。
* 移除后一个从 1 开始继续
* 输入 int n=5 ,int m=3
* 输出 4
* 思路: 递归，队列长度杀掉m前面追加最后m+x/n
* */
public class 约瑟夫环 {

    public static int lastRemaining(int n, int m) {
        return f(n, m);
    }

    public static int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);
        return (m + x) % n;
    }

    public int lastRemaining2(int n, int m) {
        int f = 0;
        for (int i = 2; i != n + 1; ++i) {
            f = (m + f) % i;
        }
        return f;
    }


    public static void main(String[] args) {
        int result = lastRemaining(5,3);
        System.out.println(result);
    }
}
