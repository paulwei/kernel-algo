package com.whl.algo.算法分类.树;

import com.whl.algo.link.LinkNode;
import com.whl.algo.tree.TreeNode;

/**
 * Created by PAUL on 2020-9-4.
 */
public class 共同祖先 {

    public LinkNode lowestCommonAncestor(LinkNode root, LinkNode p, LinkNode q) {
        if (root == null)
            return root;
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.pre, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.next, p, q);
        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }

}
