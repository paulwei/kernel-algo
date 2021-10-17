package com.whl.algo.type.recursive;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    static List<List<Integer>> res = new ArrayList<>(); //记录答案
    static List<Integer> path = new ArrayList<>();  //记录路径

    public static void main(String[] args) {
       int[] candidates = {2,3,6,7};
       int target = 7;
        List<List<Integer>>  result = combinationSum(candidates,target);
        System.out.println(JSON.toJSONString(result));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates,0, target);
        return res;
    }
    public static void dfs(int[] c, int u, int target) {
        if(target < 0) return ;
        if(target == 0)
        {
            res.add(new ArrayList(path));
            return ;
        }
        for(int i = u; i < c.length; i++){
            if( c[i] <= target)
            {
                path.add(c[i]);
                dfs(c,i,target -  c[i]); // 因为可以重复使用，所以还是i
                path.remove(path.size()-1); //回溯，恢复现场,
            }
        }
    }
}
