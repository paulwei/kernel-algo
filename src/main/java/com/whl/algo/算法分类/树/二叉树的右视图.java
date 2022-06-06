package com.whl.algo.算法分类.树;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
* 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
*          1
*     2        3
*        5
* 输出： 1,3,5
* 思路：层序遍历，区最后一个
* */
public class 二叉树的右视图 {
    public static void main(String[] args) {
        TreeNode root = build();
        rightOrder(root);
    }
    public static void  rightOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()){
          int currentLevelSize =  queue.size();
          Deque<Integer> curLevel = new LinkedList<Integer>() {
          };
          for(int i=0;i<currentLevelSize;i++){
              TreeNode node = queue.poll();
              curLevel.offer(node.val);
              if(node.left!=null){
                  queue.offer(node.left);  //按先左再右顺序插入
              }
              if(node.right!=null){
                  queue.offer(node.right);
              }
          }
          System.out.println(curLevel.getLast());//获取最后元素
        }
    }

    public static TreeNode build(){
        TreeNode _1 = new TreeNode(1);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(3);
        TreeNode _4 = new TreeNode(4);
        TreeNode _5 = new TreeNode(5);
//        _3.right=_4;
        _2.right=_5;
        _1.left=_2;
        _1.right=_3;
        return _1;
    }
}
