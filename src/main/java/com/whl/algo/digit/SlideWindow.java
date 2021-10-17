package com.whl.algo.digit;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by PAUL on 2020-9-4.
 */
public class SlideWindow {

    public static void main(String[] args) {
      int[] a = {2, 3, 4, 2, 6, 2, 5, 1};
        List<Integer> result = maxInWindows(a, 3);
        System.out.println(result);
    }

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1)
            return ret;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);  /* 大顶堆 */
        for (int i = 0; i < size; i++)
            heap.add(num[i]);
        ret.add(heap.peek());
        for (int i = 0, j = i + size; j < num.length; i++, j++) {            /* 维护一个大小为 size 的大顶堆 */
            heap.remove(num[i]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }
}
