package com.whl.algo.算法分类.滑动窗口;

import java.util.Arrays;

/*
* 输入：s1 = "ab" s2 = "eidbaooo"
* 输出：true
* 解释：s2 包含 s1 的排列之一 ("ba").
* 输入：s1= "ab" s2 = "eidboaoo"
* 输出：false
* 思路：双指针+滑动窗口，由于和顺序无关根据字符个数判断是否相同，asc码字符索引顺序
*
* */
public class 是否子串 {
    //s1子串，s2母串
    public static boolean isSubSequence(String s1,String s2){
        int n = s1.length(), m = s2.length();
        if(n>m){
            return false;
        }
        int[] cnt1= new int[26];
        int[] cnt2= new int[26];
        for(int i=0;i<n;i++){
            ++cnt1[s1.charAt(i)-'a'];
            ++cnt2[s2.charAt(i)-'a'];
        }
        if(Arrays.equals(cnt1,cnt2)){
            return true;
        }
        for(int i=n;i<m;i++){
            ++cnt2[s2.charAt(i) - 'a'];       //右边进来一个字符对应位置+1
            --cnt2[s2.charAt(i - n) - 'a'];   //左边出去一个字符对应位置-1
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }
}
