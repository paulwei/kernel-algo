package com.whl.algo.link;

/**
 * 双指针或者递归反转链表
 * 遍历直接反向修改next指针 o(n)
 */
class ReverseLink {
    public ListNode reverseList(ListNode head) {
        ListNode pre  = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode t = temp.next;
            temp.next = pre;
            pre = temp;
            temp = t;
        }
        return pre;
    }
}
