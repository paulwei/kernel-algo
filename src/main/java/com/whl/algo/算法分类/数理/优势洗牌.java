package com.whl.algo.算法分类.数理;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
* 类似 田忌赛马
* 给定两个大小相等的数组nums1和nums2，nums1相对于 nums的优势可以用满足nums1[i] > nums2[i]的索引 i的数目来描述。
* 返回 nums1的任意排列，使其相对于 nums2的优势最大化
* 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
* 输出：[2,11,7,15]
* 输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
* 输出：[24,32,8,12]
* 思路：先排序，优先最大和最大比，如果比不过，反而用最小比放弃本次机会，给以下更大机会
* */
public class 优势洗牌 {
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int[] res = new int[length];
        Arrays.sort(nums1);  // 先对数组nums1从小到大排序
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < length; i++) {
            pq.add(new int[]{nums2[i], i}); // 元素nums2[i]和对应的下标加入队列中
        }
        int left = 0;
        int right = length - 1;
        while (!pq.isEmpty()) {
            // 队列中存放的是数组num2中的元素，每次出队的都是堆中最大的值
            // 类比齐王每次都拿出剩下的马中最好的马比赛
            int[] cur = pq.poll();
            int index = cur[1];
            int val = cur[0];
            if (nums1[right] > val) {//num1排队当前最大比num2最大就用该索引填充
                res[index] = nums1[right--];
            } else {                //num1排队当前最大比num2最大小就没有大于的了，索性放弃该位用num1最小填充
                res[index] = nums1[left++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,7,11,15};
        int[] nums2 = {1,10,4,11};
        int[]  ans =  advantageCount(nums1,nums2);
        System.out.println(JSON.toJSONString(ans));
    }

}
