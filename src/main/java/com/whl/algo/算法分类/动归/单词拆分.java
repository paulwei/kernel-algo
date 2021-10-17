package com.whl.algo.算法分类.动归;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
*
* 思路:dp[i]=dp[j] && check(s[j..i−1])
* */
public class 单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
