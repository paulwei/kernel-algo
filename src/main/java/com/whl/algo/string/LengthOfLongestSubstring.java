package com.whl.algo.string;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcdbb"));

    }

    public static int lengthOfLongestSubstring(String s){
            if(s==null || s.length()<=0){
                return 0;
            }
            int left=0;
            int right=0;
            int maxLen = 0;
        Map<Character,Integer> map = new HashMap<>();
        while (right<s.length()){
           Character end = s.charAt(right);
           Integer index =  map.get(end);
            map.put(end,right);
            System.out.println(String.format("index:%s end:%s,right:%s",index,end,right));
            if(index!=null && index>=left){//如果与重复的，left滞后索引1位置
                left = index+1;
           }
           if(right-left+1>maxLen){//获取范围最大
               maxLen = right-left+1;
               System.out.println(String.format("index:%s endCharater:%s,left:%s,right:%s maxLen:%s",index,end,left,right,maxLen));
           }
           right++;
        }
//        System.out.println(JSON.toJSONString(map));
        return maxLen;

    }
}
