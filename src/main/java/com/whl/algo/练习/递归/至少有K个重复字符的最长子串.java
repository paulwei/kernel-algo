package com.whl.algo.练习.递归;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/*
*
* 输入：s = "aaabb", k = 3
输出：3
解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
*
* //分治：对于一个字符串来说，如果要求子串最少出现k次，那么如果某些字母出现的次数小于k,
//这些字母一定不会出现在最长的子串中，并且这些字母将整个字符子串分割成小段，这些小段有可能是最长的
//但是由于被分割了，还是要检查这一小段，如果某些字母出现的次数小于k,会将小段继续分割下去,
//比如字符串"aacbbbdc"，要求最少出现2次,我们记录左右闭区间，，
//第一轮[0,7]，处理"aacbbbdc"，d只出现了一次不满足，于是递归解决区间[0,5]、[7,7]
//第二轮[0,5]，处理"aacbbb"，  c只出现了一次不满足，于是递归解决区间[0,1]、[3,4]
//第二轮[7,7]，处理"c"，       c只出现了一次不满足，不继续递归
//第三轮[0,1]，处理"aa"，      满足出现次数>=2,ret=2
//第三轮[3,4]，处理"bbb"，     满足出现次数>=2 ret=3;
*
*
* */
public class 至少有K个重复字符的最长子串 {
    public static String ans="";
    public static int longestSubString(String str,int k){
        Map<Character,Integer> counter = new HashMap<>();
        for(int i=0;i<str.length();i++){
            counter.put(str.charAt(i),counter.getOrDefault(str.charAt(i),0)+1);
        }
        for(char c:counter.keySet()){
            if(counter.get(c)<k){
                int res = 0;
                for(String sub :str.split(String.valueOf(c))){//切割分治
                    int rr = longestSubString(sub,k);
                    if(rr>res && rr>ans.length()){//单次最大,比最大大
                        ans=sub;
                        res = rr;
                        System.out.println("ans:"+ans+",rr:"+rr+",res:"+res+",c:"+c+",sub:"+sub);
                    }
                }
                return res;
            }
        }
        return str.length();

    }


    public static void main(String[] args) {
        String str ="aacbbbbdddc";
        System.out.println("split:"+JSON.toJSONString(str.split("c")));
        int k = 3 ;
        int maxLen = longestSubString(str,k);
        System.out.println(maxLen);
        System.out.println(ans);
    }
}
