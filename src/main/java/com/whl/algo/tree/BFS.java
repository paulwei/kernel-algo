package com.whl.algo.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS {

    void bfs(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll(); //取一个节点,然后塞入左右子节点
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
