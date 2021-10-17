package com.whl.algo.算法分类.数理;

/*
* 输入：00000000000000000000000000001011
* 输出：3
* 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
* 思路:n&(n-1) 最后位置 1 置为 0
* */
public class 位1的个数 {
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

}
