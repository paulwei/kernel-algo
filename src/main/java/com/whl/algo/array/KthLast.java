package com.whl.algo.array;

import java.util.PriorityQueue;

public class KthLast {
    public static void main(String[] args) {
        int[] nums = {5,3,4,2,1,8,9};
        int result = findKthLast(nums,2);
        System.out.println(result);
    }
    public static int findKthLast(int[] nums,int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        for(int num:nums)
        {
            minHeap.add(num);
            while(minHeap.size()>k)  {
              Integer poll =  minHeap.poll();//小堆顶扔掉
                System.out.println("add num:"+num+",poll:"+poll);
            }
        }
        return minHeap.poll();//剩余倒数第 K 个
    }
}
