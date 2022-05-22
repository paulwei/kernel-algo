package com.whl.algo.算法分类.树;

import com.whl.algo.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
* 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
* 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
* 输出：[[5,4,11,2],[5,8,4,5]]
* 思路：回溯算法迭代
*
* */
public class 路径总和II {
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.pollLast();//减枝
    }




}
