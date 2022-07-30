package com.whl.algo.算法分类.回溯;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/*
* 输入3,输出所有可能匹配组合
* ((())),()()(),(())(),()(())
* 思路：保证右括号数目不多余左括号数目
* */
public class 括号组合 {
    static List<String>  res = new ArrayList<>();
    static int n =3;
    public static void main(String[] args) {

        String letter = "";
        comPairs(letter,0,0);
        System.out.println(JSON.toJSONString(res));
    }

    public static void comPairs(String letter,int left,int right){
        if(letter.length()==2*n){
            System.out.println(letter);
            res.add(letter);
            return ;
        }
        if(left>right){//两条分支递归
            comPairs(letter+")",left,right+1);
        }
        if(left<n){//两条分支递归
            comPairs(letter+"(",left+1,right);
        }
    }
}
