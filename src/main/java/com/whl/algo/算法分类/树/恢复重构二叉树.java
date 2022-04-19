package com.whl.algo.算法分类.树;

import com.alibaba.fastjson.JSON;
import com.whl.algo.tree.TreeNode;

import java.util.Arrays;

/*
* 从前序与中序遍历序列构造二叉树
* 根据中序遍历+后序遍历 确定恢复二叉树
* 后序遍历最后一个是跟,然后根据中序遍历,确定左右子树
* 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
* Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
* Output: [3,9,20,null,null,15,7]
* */
public class 恢复重构二叉树 {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 8, 5, 4, 10, 20, 15, 7};
        int[] inorder = {4, 5, 8, 10, 9, 3, 15, 20, 7};
        TreeNode root =  buildTree(preorder,inorder);
        System.out.println(JSON.toJSONString(root));
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0) {
            return null;
        }
        //根据前序数组的第一个元素，就可以确定根节点
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=0;i<preorder.length;++i) {
            //用preorder[0]去中序数组中查找对应的元素
            if(preorder[0]==inorder[i]) {
                //将前序数组分成左右两半，再将中序数组分成左右两半
                //之后递归的处理前序数组的左边部分和中序数组的左边部分
                //递归处理前序数组右边部分和中序数组右边部分
                int[] pre_left = Arrays.copyOfRange(preorder,1,i+1);
                int[] pre_right = Arrays.copyOfRange(preorder,i+1,preorder.length);
                int[] in_left = Arrays.copyOfRange(inorder,0,i);
                int[] in_right = Arrays.copyOfRange(inorder,i+1,inorder.length);
                root.left = buildTree(pre_left,in_left);
                root.right = buildTree(pre_right,in_right);
                break;
            }
        }
        return root;
    }
}
