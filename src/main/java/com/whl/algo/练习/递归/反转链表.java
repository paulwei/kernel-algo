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
//        System.out.println("return:"+node.val);//一直打印头节点4
        return null; //
    }

    public static void main(String[] args) {
//        LinkNode node = build();

        LinkNode a = new LinkNode(1);
        LinkNode b = new LinkNode(2);
        LinkNode c = new LinkNode(3);
        LinkNode d = new LinkNode(4);
        a.next=b;
        b.next=c;
        c.next=d;

        reverse(a);

        while (d!=null){
            System.out.println(d.val);
            d = d.next;
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
