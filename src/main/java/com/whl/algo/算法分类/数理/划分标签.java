package com.whl.algo.算法分类.数理;

import com.alibaba.fastjson.JSON;
import com.whl.algo.string.MergeRange;

import java.util.ArrayList;
import java.util.List;

/*
* 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表
* 思路:* 先存储每个字母最后出现的位置，最后遍历一次 o(n)

 *
* */
public class 划分标签 {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i) {
            last[S.charAt(i) - 'a'] = i;
        }
        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {//最后一个索引位置切割
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        System.out.println(JSON.toJSONString(last));
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> result =  new MergeRange().partitionLabels("abaaced");
        System.out.println(result);
    }
}
