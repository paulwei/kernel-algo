package com.whl.algo.算法分类.链表;

/*
* 输入:1-->2-->3
* 输出:3-->2-->1
* 思路:双指针
* */
public class 链表逆序 {

    public static ListNode reverse(ListNode head){
        ListNode pre = head;
        while(true){
            ListNode cur = pre.next;
            ListNode temp = cur.next;
            if(temp==null){
                return cur;
            }
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
    }

//    public static ListNode recusive(ListNode head){
//       return
//    }
}
