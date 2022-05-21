package com.whl.algo.算法分类.链表;

/*
* 思路： 归并排序：先递归拆分再合并递归两个有序子集
*
* */
public class 排序链表 {
    public static ListNode sort(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        //快慢指针取中点，分段拆分
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next=null;//切分链表
        ListNode l1 = sort(head);//递归切分排序
        ListNode l2 = sort(head2);
        return merge(l1,l2);//合并两个有序子集
    }

    public static ListNode merge(ListNode a,ListNode b){
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        if(a.val<b.val){
            a.next=merge(a.next,b);
            return a;
        }else{
            b.next=merge(a,b.next);
            return b;
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(2);
        a.next=b;
        b.next=c;
        c.next=d;
        ListNode r = sort(a);
        while (r!=null){
            System.out.println(r.val);
            r = r.next;
        }
    }
}
