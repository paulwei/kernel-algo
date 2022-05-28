package com.whl.algo.算法分类.树;

import com.whl.algo.tree.TreeNode;

/*
* 输入 ：          1
*           2         3
*        4     5   6    7
* 输出：  4 5 2 6 7 3 1
*
*
* */
public class 后序遍历 {
    public static void postOrder(TreeNode treeNode){
        if(treeNode==null){
            return ;
        }
        System.out.println(treeNode.val);
        postOrder(treeNode.left);
        postOrder(treeNode.right);
    }

    public static TreeNode postOrderBuild(TreeNode treeNode){
        if(treeNode==null){
            return null;
        }
        treeNode.left =  postOrderBuild(treeNode.left);
        treeNode.right = postOrderBuild(treeNode.right);
        return treeNode;
    }

    public static TreeNode buildTree(int i){
        if(i>7){
            return null;
        }
        TreeNode root = new TreeNode(i);
        root.left = buildTree(i*2);
        root.right = buildTree(i*2+1);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree(1);
        TreeNode t = postOrderBuild(root);
        postOrder(root);
    }

}
