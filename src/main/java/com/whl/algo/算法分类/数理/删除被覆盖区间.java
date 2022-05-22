package com.whl.algo.算法分类.数理;


import java.util.Arrays;

/*
*
*
* */
public class 删除被覆盖区间 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        int max = -1;
        int count = intervals.length;
        for(int i = 0;i < intervals.length;i ++) {
            if (intervals[i][1] <= max) {
                count --;
            }
            max = Math.max(max, intervals[i][1]);
        }
        return count;
    }

}
