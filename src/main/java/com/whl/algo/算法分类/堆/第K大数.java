package com.whl.algo.算法分类.堆;

import java.util.Comparator;
import java.util.PriorityQueue;


/*
 * 思路 小顶堆中扔元素，只保留K个，最后poll倒数第K个
 * */
public class 第K大数 {
    public static void main(String[] args) {
        int[] nums = {5,3,4,2,1,8,9};
        Integer topK =  findKthLast(nums,2);
        System.out.println(topK);
    }

    public static int findKthLast(int[] nums,int k){
        PriorityQueue<Integer> heap = new PriorityQueue((Comparator<Integer>) (o1, o2) -> o1-o2);
        for(Integer num:nums){
            heap.add(num);
            while (heap.size()>k){
                heap.poll();
            }
        }
       return heap.poll();
    }
}
