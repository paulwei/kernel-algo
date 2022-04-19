package com.whl.algo.string;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 先存储每个字母最后出现的位置，最后遍历一次 o(n)
 */
public class MergeRange {

    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i) {
            last[S.charAt(i) - 'a'] = i;
        }
        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
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
