package com.whl.algo.算法分类.字符串;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
* 思路:哈希
* */
public class 第一个不重复字符串 {
    public static Character firstNoDulicate(String s){
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.putIfAbsent(c,map.get(c)+1);
            }else{
                map.putIfAbsent(c,1);
            }
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return null;

    }
}
