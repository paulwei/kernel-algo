package com.whl.algo.算法分类.排序;


import java.util.PriorityQueue;
import java.util.Queue;

/*
* 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
例如，
[2,3,4] 的中位数是 3
[2,3] 的中位数是 (2 + 3) / 2 = 2.5
*思路:大根堆+小根堆,双堆
* */
public class 数据流中的中位数 {
    Queue<Integer> A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
    Queue<Integer> B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半

    public void addNum(int num) {
        if(A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());//拿掉最小的,剩余就是最大几个
        } else {
            B.add(num);
            A.add(B.poll());//大顶堆拿掉最大的,剩余就是最小的
        }
    }
    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }


}
