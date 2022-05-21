package com.whl.algo.算法分类.回溯;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/*
* 输入：n = 3
* 输出：["((()))","(()())","(())()","()(())","()()()"]
* 思路：
*    就是不停选括号，要么选左括号，要么选右括号。
  并有这些约束的：
  只要(有剩，就可以选(。 (((((这么选，都还不能判定为非法。
  当剩下的)比(多时，才可以选)，否则，)不能选，选了就非法。
  因为：剩下的)比(少，即，使用的)比(多，不能成双成对
  lc 左括号数量，rc右括号数量

* */
public class 括号生成 {
    static List<String> ans = new ArrayList<>();
    public static List<String> genParentheses(int n){
        dfs(n,0,0,"");
        return ans;
    }

    //lc 左括号数量，rc右括号数量
    public static void dfs(int n,int lc,int rc,String str){
        if(lc==n && rc==n){
            ans.add(str);
        }
        if(lc<n){
            dfs(n,lc+1,rc,str+"(");
        }
        if(rc<n && lc>rc){
            dfs(n,lc,rc+1,str+")");
        }
    }

    public static void main(String[] args) {
        genParentheses(3);
        System.out.println(JSON.toJSONString(ans));
    }


}
