package com.whl.algo.string;

/**
 * Created by PAUL on 2020-9-4.
 */
public class TwoStrEq {
    public static void main(String[] args) {
        String s = "aac";
        String t = "aba";
        boolean result = isEq(s,t);
        System.out.println(result);
    }

    //错误算法
    public static boolean isEq(String s, String t) {
        int[] arr = new int[26];
        for (int i = 0;i < s.length();i ++) {
            arr[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0;i < t.length();i ++) {
            arr[s.charAt(i) - 'a'] -= 1;
        }
        for (int i : arr) {
            if (i != 0)return false;
        }
        return true;
    }
}
