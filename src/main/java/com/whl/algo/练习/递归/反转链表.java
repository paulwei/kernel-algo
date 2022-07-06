package com.whl.algo.练习.递归;


import com.whl.algo.算法分类.链表.LinkNode;

public class 反转链表 {
    public static LinkNode reverse(LinkNode head){
        if(head==null || head.next==null){
            return head;
        }
        LinkNode node = reverse(head.next);//一直递归走到最后节点如4
        head.next.next = head; //前一个节点赋值给后一个节点
        head.next=null; //前一节点next断开
        return node; //返回当前节点
    }

    public static void main(String[] args) {
        LinkNode node = build();
        LinkNode head = reverse(node);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static LinkNode build(){
        LinkNode pre=null;
        for(int i=4;i>0;i--){
            LinkNode cur = new LinkNode(i);
            if(pre!=null){
                cur.next=pre;
            }
            pre=cur;
        }
        return pre;
    }
}
