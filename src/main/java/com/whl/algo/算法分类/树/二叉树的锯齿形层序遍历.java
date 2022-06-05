package com.whl.algo.算法分类.树;

import com.alibaba.fastjson.JSON;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/*
* 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
* 输入：root = [3,9,20,null,null,15,7]
* 输出：[[3],[20,9],[4,6,15,7]]
*         3
*    9         20
* 4     6    15     7
*
*
*
* */
public class 二叉树的锯齿形层序遍历 {

    public static void main(String[] args) {
        TreeNode root = build();
        zOrder(root);

    }

    public static void zOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedBlockingDeque();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            Deque<Integer> dequeue = new LinkedBlockingDeque();
            int currentLevelSize = queue.size();
            level++;
            System.out.println("level:"+level);
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();
                if(level % 2 ==0){
                    dequeue.offerFirst(node.val);
                }else{
                    dequeue.offerLast(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            System.out.println(JSON.toJSONString(dequeue));
        }
    }

    public static TreeNode build(){
        TreeNode _15 = new TreeNode(15);
        TreeNode _7 = new TreeNode(7);
        TreeNode _20 = new TreeNode(20);
        _20.left=_15;
        _20.right=_7;
        TreeNode _9 = new TreeNode(9);
        TreeNode _3 = new TreeNode(3);
        _3.left = _9;
        _3.right=_20;
        TreeNode _4 = new TreeNode(4);
        TreeNode _6 = new TreeNode(6);
        _9.left = _4;
        _9.right=_6;
        return _3;
    }
}
