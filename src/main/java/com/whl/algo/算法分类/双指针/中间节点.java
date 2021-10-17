package com.whl.algo.算法分类.双指针;

import com.whl.algo.string.ListNode;

/*
*
* 快慢指针,寻找中间节点,慢指针1步,快指针间隔2步
* */
public class 中间节点 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
