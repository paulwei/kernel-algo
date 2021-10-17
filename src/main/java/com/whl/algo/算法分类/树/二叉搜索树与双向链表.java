package com.whl.algo.算法分类.树;

import com.whl.algo.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
* 二叉搜索树:左<根<右
* 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表
* 思路:中序遍历
* */
public class 二叉搜索树与双向链表 {

    static List<TreeNode> result = new ArrayList<>();

    public static void buildDoubleLink(TreeNode treeNode){
        inOrder(treeNode);
        for(int i=0;i<result.size();i++){//构建链双向链表

        }
    }
    public static void inOrder(TreeNode treeNode){
        inOrder(treeNode.left);
        result.add(treeNode);
        inOrder(treeNode.right);
    }
}
