package com.whl.algo.算法分类.字符串;

/**
 * 水平扫描 o(n)
 */
public class 最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String pre = "";
        int i = 0;
        while (true) {
            if (strs[0].length() == i) {
                return pre;
            }
            char temp = strs[0].charAt(i);
            for (int k = 1; k < strs.length; k++) {
                if (strs[k].length() == i || temp != strs[k].charAt(i)) {
                    return pre;
                }
            }
            pre += temp;
            i++;
        }
    }

    public static void main(String[] args) {
        String[] s = new String[]{"crtt", "crtx"};
        System.out.println(new 最长公共前缀().longestCommonPrefix(s));
    }
}
