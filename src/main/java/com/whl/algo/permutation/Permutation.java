package com.whl.algo.permutation;

import com.alibaba.fastjson.JSON;

import java.util.*;

/*
* 深度优先遍历+回溯算法
*
* */
public class Permutation {

    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;

                System.out.println("  递归之前 => " + path);
                dfs(nums, len, depth + 1, path, used, res);

                used[i] = false;
                path.removeLast();
                System.out.println("递归之后 => " + path);
            }
        }
    }

    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
//        System.out.println(String.format(" access backtrack n:%s,first:%s,output:%s",n,first, JSON.toJSONString(output)));

        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
            System.out.println(String.format("满足 backtrack n:%s,first:%s,output:%s",n,first, JSON.toJSONString(output)));

        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            System.out.println(String.format("before first:%s,i:%s,output:%s",first,i,JSON.toJSONString(output)));

            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
            System.out.println(String.format("after first:%s,i:%s,output:%s",first,i,JSON.toJSONString(output)));

        }
    }



    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = permute2(nums);
        System.out.println(lists);
    }

}
