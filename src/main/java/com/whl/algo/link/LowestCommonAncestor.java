package com.whl.algo.link;

/**
 * Created by PAUL on 2020-9-4.
 */
public class LowestCommonAncestor {

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
