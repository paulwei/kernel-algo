package com.whl.algo.算法分类.树;

import com.whl.algo.tree.TreeNode;

import java.util.HashSet;

/*
*BST 二叉搜索树
* 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
* 思路 1:通过 hash 递归遍历所有节点如果hash中存在目标 K-root.val 返回 true
* 思路 2: 通过中序遍历即升序遍历,然后双指针左右中间逼近目标值
*
* */
public class 两数之和BST {
    public static boolean findTarget(TreeNode root,int k){
        HashSet set = new HashSet();
       return findTarget(root,set,k);
    }
    public static boolean findTarget(TreeNode root,HashSet set,int k){
        if(root==null){
            return false;
        }
        if(set.contains(k-root.val)){
            return true;
        }
       return findTarget(root.left,set,k) || findTarget(root.right,set,k);

    }

}
