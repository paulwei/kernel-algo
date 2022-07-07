package com.whl.algo.算法分类.链表;
/*
*
*
* */
public class 反转链表{

    //递归
    public static ListNode reverseList(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if(head==null || head.next==null) {
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseList(head.next);
        //这里请配合动画演示理解
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }

    public static ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode node = reverse(head.next);//一直递归走到最后节点如4
        head.next.next = head; //前一个节点赋值给后一个节点
        head.next=null; //前一节点next断开
        System.out.println("node:"+node.val);//一直打印3节点
        return node; //返回头节点,局部变量防止丢失串联
    }

    //双指针
    public static ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode temp = cur.next; //第三个节点临时
            cur.next=pre;
            pre = cur;
            cur=temp;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next=b;
        b.next=c;
        ListNode r = reverse(a);
        while (r!=null){
            System.out.println(r.val);
            r = r.next;
        }
    }

}
