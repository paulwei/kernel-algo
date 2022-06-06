package com.whl.algo.算法分类.树;

import com.alibaba.fastjson.JSON;
import com.whl.algo.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* root开始每层遍历，广度优先搜索
*
* */
public class 层序遍历 {
    public static void main(String[] args) {
        TreeNode root = buildTree(1);
        levelOrder(root);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size(); //这个上层while循环获取size
            for (int i = 1; i <= currentLevelSize; ++i) {//层数
                TreeNode node = queue.poll(); //当层循环拿出一个塞入两个左右子,随着currentLevelSize变大，累加节点变大
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            System.out.println(JSON.toJSONString(level));
            ret.add(level);
        }

        return ret;
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

}
