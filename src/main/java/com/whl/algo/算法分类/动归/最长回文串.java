package com.whl.algo.算法分类.动归;

/*
* 给你一个字符串 s，找到 s 中最长的回文子串。
* 输入：s = "babad"
* 输出："bab"
* 解释："aba" 同样是符合题意的答案。
* 思路:dp[l][r]=true 并且(l-1)和（r+1)两个位置为相同的字符，此时 dp[l-1][r+1]=true。
* */
public class 最长回文串 {

    public static String longestPalindrome(String s){
        int maxLen = 1;
        int begin = 0;
        int len = s.length();
        boolean[][] dp=new boolean[len][len];
        char[] charArray = s.toCharArray();
        for(int i=0;i<s.length();i++){
            dp[i][i]=true;
        }
        for(int j=1;j<len;j++){
              for(int i=0;i<j;i++){ //i到j,j走一步，i从0到j
                if(charArray[i]!=charArray[j]){
                    dp[i][j]=false;
                }else{
                    if(j-i<3){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];//之前已计算过
                    }
                }
                  // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                  if (dp[i][j] && j - i + 1 > maxLen) {
                      maxLen = j - i + 1;
                      begin = i;
                  }
              }
        }
        return s.substring(begin, begin + maxLen);
    }
}
