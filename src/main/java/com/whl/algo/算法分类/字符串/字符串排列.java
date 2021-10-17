package com.whl.algo.算法分类.字符串;


import com.alibaba.fastjson.JSON;

//改变序列
public class 字符串排列 {

    public static void permute(char[] str, int low, int high) {
        if (low >= high) {
            System.out.println(new String(str));
            return;
        }
        for (int i = low; i < high; i++) {
            //先交换过去
            char c = str[low];
            str[low] = str[i];
            str[i] = c;

            System.out.println(String.format("before low:%s,i:%s,str:%s",low,i, JSON.toJSONString(str)));

            permute(str, low + 1, high);

            System.out.println(String.format("after low:%s,i:%s,str:%s",low,i,JSON.toJSONString(str)));

            //递归后交换回来
            c = str[low];
            str[low] = str[i];
            str[i] = c;
        }
    }

    public static void main(String[] args) {
        permute("abc".toCharArray(),0,"abc".length());

    }
}
