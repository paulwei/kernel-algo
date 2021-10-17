package com.whl.algo.算法分类.链表;

import com.whl.algo.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
* 二叉树镜像
* 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
* 思路:递归+哈希
* * */
public class 复制带随机指针的链表 {
    static Map<TreeNode,TreeNode> cached = new HashMap<>();

    public static TreeNode copy(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode newNode = new TreeNode(root.val);
        cached.putIfAbsent(root,newNode);
        newNode.left=copy(root.left);
        newNode.right=copy(root.right);
        return cached.get(root);
    }
}
