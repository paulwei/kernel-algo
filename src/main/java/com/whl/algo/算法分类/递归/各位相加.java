package com.whl.algo.算法分类.递归;

/*
* 输入: 38
输出: 2
解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
*
* */
public class 各位相加 {
    public static int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int next = 0;
        while (num != 0) {
            next = next + num % 10;
            num /= 10;
            System.out.println(num+":"+next);
        }
        return addDigits(next);
    }

    public static void main(String[] args) {
        int result = addDigits(38);
        System.out.println(result);
    }
}
