package com.whl.algo.link;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {
    public static void main(String[] args) {

    }
    public static boolean hasCycle(LinkNode head){
        Set<LinkNode> set = new HashSet<LinkNode>();
        while(head!=null){
            if(!set.add(head)){
                return true;
            }
            head=head.next;
        }
        return false;
    }
}
