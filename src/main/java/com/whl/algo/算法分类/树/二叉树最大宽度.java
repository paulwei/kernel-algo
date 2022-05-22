package com.whl.algo.算法分类.树;

import com.whl.algo.tree.TreeNode;

import java.util.LinkedList;

/*
* 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
* 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
* 思路：假设当前节点编号为root.val，那么：左子节点编号: root.val * 2 - 1  右子节点编号: root.val * 2
* */
public class 二叉树最大宽度 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        root.val = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res = Math.max(queue.peekLast().val - queue.peekFirst().val + 1, res);
            for(int i=0;i<size;i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    cur.left.val = cur.val * 2 - 1;
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    cur.right.val = cur.val * 2;
                    queue.offer(cur.right);
                }
            }
        }
        return res;
    }

}
