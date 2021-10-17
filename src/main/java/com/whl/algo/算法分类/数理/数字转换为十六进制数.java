package com.whl.algo.算法分类.数理;

public class 数字转换为十六进制数 {
    public static String toHex(int num) {
        final char[]  chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb    = new StringBuilder();
        do {
            sb.append(chars[num & 15]);//每次截取后 15 bit,映射成对应数字
            System.out.println(num & 15);
            num >>>= 4;//向右移除4,移除低四位,保留高位
        } while (num > 0);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String result = toHex(18);
        System.out.println(result);
    }
}
