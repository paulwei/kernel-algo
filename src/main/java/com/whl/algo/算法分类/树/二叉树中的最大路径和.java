package com.whl.algo.算法分类.树;

/*
* 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。
* 该路径 至少包含一个 节点，且不一定经过根节点。路径和 是路径中各节点值的总和。一个二叉树的根节点 root ，返回其 最大路径和
* 思路：路径停在当前子树的根节点，在当前子树的最大收益：root.val
* 走入左子树，在当前子树的最大收益：root.val + dfs(root.left)
* 走入右子树，在当前子树的最大收益：root.val + dfs(root.right)
* 这对应了前面所说的三种选择，最大收益取三者最大：root.val+max(0, dfs(root.left), dfs(root.right))
*
*
* */
public class 二叉树中的最大路径和 {
    public static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root =  buildTree(1);
        maxSumPath(root);
        System.out.println(maxSum);
    }

    public static int maxSumPath(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftMax = Math.max(maxSumPath(root.left),0);
        int rightMax = Math.max(maxSumPath(root.right),0);
        int sum =  root.val+leftMax+rightMax;
        maxSum = Math.max(maxSum,sum);
        //左右两个递归，所以root.val+哪个子树大
        return root.val+Math.max(leftMax,rightMax);
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
