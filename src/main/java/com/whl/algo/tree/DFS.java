package com.whl.algo.tree;


public class DFS {

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
    }

}
