package com.whl.algo.算法分类.树;

public class 二叉树最大深度 {

    public static int max = Integer.MIN_VALUE;

    public static void maxDepth(TreeNode root,int depth){
        if(root==null){
            max = Math.max(max,depth);
            return;
        }
        System.out.println(root.val+" depth:"+depth);
        maxDepth(root.left,depth+1);
        maxDepth(root.right,depth+1);
    }

    public static void main(String[] args) {
        TreeNode root = buildTree(1);
        maxDepth(root,0);
        System.out.println(max);
    }


    public static TreeNode buildTree(int i){
        if(i>6){
            return null;
        }
        TreeNode root = new TreeNode(i);
        System.out.println("i:"+i);
        root.left = buildTree(i*2);
        root.right = buildTree(i*2+1);
        return root;
    }


}
