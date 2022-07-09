package com.whl.algo.算法分类.回溯;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/*
*
* 深度遍历
*
* */
public class 全排列 {
    static List<List<Integer>> ans = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        dfs(nums, new ArrayList<>());
        return ans;
    }

    private static void dfs(int[] nums, List<Integer> tmp) {
//        System.out.println(Arrays.toString(nums) + "," + tmp);
        if (tmp.size() == nums.length) {
            ans.add(new ArrayList<>(tmp));
        } else {
            for (int num : nums) {
                if (!tmp.contains(num)) {
                    tmp.add(num);
                    dfs(nums, tmp);
                    //回溯到前一个继续其它路径试探
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
    public static void main(String[] args) {
          int[] nums={1,2,3};
          permute(nums);
         System.out.println(JSON.toJSONString(ans));
    }
}
