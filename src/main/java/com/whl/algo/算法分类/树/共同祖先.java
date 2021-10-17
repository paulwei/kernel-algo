package com.whl.algo.算法分类.树;

import com.whl.algo.link.LinkNode;

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
}
