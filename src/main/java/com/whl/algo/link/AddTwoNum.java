package com.whl.algo.link;

public class AddTwoNum {


    /*
    *
    * 示例：
        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
        输出：7 -> 0 -> 8
        原因：342 + 465 = 807
    *
    * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        int carry = 0;
        ListNode p=l1;
        ListNode q=l2;
        ListNode cur= node;
        while(p!=null || q!=null){
            int x = p!=null?p.val:0;
            int y = q!=null?q.val:0;
            int summary = x+y+carry;
            carry = summary/10;
            cur.next=new ListNode(summary%10);
            cur = cur.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if(carry>0){
            cur.next=new ListNode(carry);
        }
        return node;
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}