package com.whl.algo.bit;

/**
 * Created by PAUL on 2020-7-19.
 */
public class CombinationBit {
    public static void main(String[] args) {
        String str[] = { "A", "B", "C", "D", "E" };
        int nCnt = str.length;
        int nBit = (0xFFFFFFFF >>> (32 - nCnt));
        System.out.println(String.format("length:%s,nBit:%s",nCnt,nBit));
        for (int i = 1; i <= nBit; i++) {
            for (int j = 0; j < nCnt; j++) {
                if ((i << (31 - j)) >> 31 == -1) {
                    System.out.print(str[j]);
                }
            }
            System.out.println("");
        }
    }
}
