package com.whl.algo.算法分类.数理;

/*
* 颠倒给定的 32 位无符号整数的二进制位。
*
* */
public class 颠倒二进制位 {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int ans = 0;
        for(int i = 0;i<32;i++) {
            ans <<= 1;
            ans+=(n&1);//n最后一位是否是1，是填充ans左移空出位置
            n>>=1;     //n丢掉最后1位
        }
        return ans;
    }

    public static void main(String[] args) {
        int a = 0b00000010100101000001111010011100;
        int ans = reverseBits(a);
        System.out.println(ans);
    }

}
