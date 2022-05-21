package com.whl.algo.算法分类.双指针;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 合并区间
* 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
* 输出：[[1,6],[8,10],[15,18]]
* 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
* 思路：
* */
public class 区间合并 {
    public static  List<int[]> mergeSegment(int[][] intervals){
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        int i =0 ;
        List<int[]> ans = new ArrayList<>();
        while (i<intervals.length){
            if(i==intervals.length-1){
                ans.add(intervals[i]);
                break;
            }
            if(intervals[i+1][0]<intervals[i][1]){//合并
                intervals[i+1][0] = intervals[i][0];
                intervals[i+1][1] = Math.max(intervals[i][1],intervals[i+1][1]);
            }else{
                ans.add(intervals[i]);
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        List<int[]> ans = mergeSegment(intervals);
        System.out.println(JSON.toJSONString(ans));
    }


}
