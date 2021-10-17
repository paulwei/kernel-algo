package com.whl.algo.算法分类.递归;

import com.whl.algo.tree.TreeNode;

/*
* 递归
* */
public class 翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
