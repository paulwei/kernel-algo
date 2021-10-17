package com.whl.algo.link;

/*
* 双指针间距 K,快慢指针
*
*
* */
public class KthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for(int i = 0; i < k; i++)
            former = former.next;
        while(former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}
