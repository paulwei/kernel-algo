package com.whl.algo.算法分类.数理;

/*
* s = "leetcode"
返回 0.
s = "loveleetcode",
返回 2.
*
* 思路: 先建 26 个字母数组遍历存储该字符第一次位置,然后再遍历一遍
* a b c d e
* 0 1 2 3 4 [下标] 存储 String索引
* */
public class 字符串中的第一个唯一字符 {

    public static void main(String[] args) {
        int result = getUnniqueIndex("loveleetcode");
        System.out.println(result);
    }

    public static int getUnniqueIndex(String s){
        int[] ans = new int[26];
        char[] arrs = s.toCharArray();
        for(int i=0;i<arrs.length;i++){
            ans[arrs[i]-'a']=i;//每个字符最后下标
        }
        for(int i=0;i<arrs.length;i++){//重新遍历
            if(ans[arrs[i]-'a']==i){
                return i;
            }
        }
        return -1;
    }
}
