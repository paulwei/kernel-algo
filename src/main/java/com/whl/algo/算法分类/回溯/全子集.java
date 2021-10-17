package com.whl.algo.算法分类.回溯;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全子集 {
    static List<List<Integer>> ans = new ArrayList<>();
    public static List<List<Integer>> subset(int[] nums) {
        dfs(nums, new ArrayList<>());
        return ans;
    }

    private static void dfs(int[] nums, List<Integer> tmp) {
        System.out.println(Arrays.toString(nums) + "," + tmp);
        ans.add(new ArrayList<>(tmp));
        if (tmp.size() == nums.length) {
            return;
        } else {
            for (int num : nums) {
                if (!tmp.contains(num)) {
                    tmp.add(num);
                    dfs(nums, tmp);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums={1,2,3};
        subset(nums);
        System.out.println("ans:"+JSON.toJSONString(ans));
    }
}
