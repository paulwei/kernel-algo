package com.whl.algo.算法分类.贪心;

import java.util.*;

/*
* 获取气球坐标,取交集,尽可能少射击射穿
* 思路:贪心策略,将左端点顺序排列,前一个右端点小于后一个左端点 射击次数+1,更新右端点
* */
public class 射击气球 {
    public static int findMinArrowShots(List<int[]> points){
        Collections.sort(points, new Comparator<int[]>() {//左端点排序
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int arrowCount = 1 ;
        int ineterval_right = points.get(0)[1];
        for(int i=1;i<points.size();i++){
            int[] p = points.get(i);
            if(ineterval_right>=p[0]){
                if(ineterval_right>p[1]){
                    ineterval_right=p[1];
                }
            }else{
                arrowCount++;
                ineterval_right=p[1];
            }
        }
        return arrowCount;
    }

    public static void main(String[] args) {
        int[] a ={10,16};
        int[] b ={2,8};
        int[] c ={1,6};
        int[] d ={7,12};
        List list = new ArrayList();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
       int arrowCount = findMinArrowShots(list);
        System.out.println(arrowCount);
    }
}
