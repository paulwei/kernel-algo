package com.whl.algo.算法分类.链表;

public class 链表相加 {


    /*
    *
    * 示例：
        输入：(1 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
        输出：7 -> 0 -> 8
        原因：1342 + 465 = 1807
    *
    * */


    public static void main(String[] args) {
        ListNode _11 = new ListNode(3);
        ListNode _12 = new ListNode(4);
        ListNode _13 = new ListNode(2);
        ListNode _14 = new ListNode(1);
        _12.next=_11;_13.next=_12;_14.next=_13;
        ListNode _21 = new ListNode(4);
        ListNode _22 = new ListNode(6);
        ListNode _23 = new ListNode(5);
        _22.next=_21;_23.next=_22;
        addTwoNumbers(_14,_23);
    }

    public static void printf(ListNode head){
        if(head.next==null){
            System.out.println(head.val);
            return;
        }
        printf(head.next);
    }

    public static ListNode getNode(ListNode head){
        if(head.next==null){
            return head;
        }
        return getNode(head.next);
    }

    public static int addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1.next==null && l2.next==null){
            int x = l1!=null?l1.val:0;
            int y = l2!=null?l2.val:0;
            int summary = x+y;
            int cur = summary%10;
            int carry = summary/10;
            System.out.println("x:"+x+",y:"+y+",cur:"+cur+",carry:"+carry);
            return carry;
        }/*else if(l1==null){
            return l2.val;
        }else if(l2==null){
            return l1.val;
        }*/
        int carry = addTwoNumbers((l1.next!=null?l1.next:l1),(l2.next!=null?l2.next:l2));
        int x = l1!=null?l1.val:0;
        int y = l2!=null?l2.val:0;
        int summary = x+y+carry;
        int cur = summary%10;
        carry = summary/10;
        System.out.println("x:"+x+",y:"+y+",cur:"+cur+",carry:"+carry);

        return carry;
    }


    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
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