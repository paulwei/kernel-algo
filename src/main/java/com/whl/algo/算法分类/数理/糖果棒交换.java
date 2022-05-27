package com.whl.algo.算法分类.数理;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
**
*爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小
*输入：A = [1,1], B = [2,2]
*输出：[1,2] 1+2=2+1
* 输入：A = [1,2], B = [2,3]
* 输出：[1,2] 2+2 = 1+3
* 思路:sumA−x+y=sumB+x−y
* x=y+(sumA−sumB)/2
* 分别在 A和 B 中寻找满足上述条件的公式
* */
public class 糖果棒交换 {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = Arrays.stream(aliceSizes).sum();
        int sumB = Arrays.stream(bobSizes).sum();
        int delta = (sumA - sumB) / 2;
        Set<Integer> rec = new HashSet<Integer>();
        for (int num : aliceSizes) {
            rec.add(num);
        }
        int[] ans = new int[2];
        for (int y : bobSizes) {
            int x = y + delta;
            if (rec.contains(x)) {
                ans[0] = x;
                ans[1] = y;
                break;
            }
        }
        return ans;
    }

}
