package com.whl.algo.算法分类.数理;

/*
* 统计所有小于非负整数 n 的质数的数量。
* 输入：n = 10
* 输出：4
* 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
* 思路:大于 2 比较<开根之前能否取余==0
* */
public class 计数质数 {

    private static boolean isPrime(int num) {
        int max = (int)Math.sqrt(num);
        for (int i = 2; i <= max; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int r = (int) Math.sqrt(7);
        boolean result = isPrime(17);
        System.out.println(result);
    }
}
