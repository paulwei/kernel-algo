package com.whl.algo.算法分类.树;

import com.whl.algo.tree.TreeNode;

public class 中序遍历 {
    public static void inOrder(TreeNode treeNode){
        if(treeNode==null){
            return;
        }
        inOrder(treeNode.left);
        System.out.println(treeNode.val);
        inOrder(treeNode.right);
    }
}
