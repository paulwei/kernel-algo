package com.whl.algo.算法分类.链表;

/**
 * Created by PAUL on 2020-7-19.
 */
public class LinkNode {
    public int val;
    public LinkNode next;
    public LinkNode pre;

    public LinkNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }

    public LinkNode getPre() {
        return pre;
    }

    public void setPre(LinkNode pre) {
        this.pre = pre;
    }
}
