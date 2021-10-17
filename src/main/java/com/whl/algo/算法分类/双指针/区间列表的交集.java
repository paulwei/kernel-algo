package com.whl.algo.算法分类.双指针;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/*
* 输入：firstList = [[0,2],[5,10],[13,23],[24,25]],
*      secondList = [[1,5],[8,12],[15,24],[25,26]]
* 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
* 思路: 排序+双指针
* 技巧: 求交集 [0]小边界取大值 < [1]大边界取小值
* */
public class 区间列表的交集 {

    public static List<int[]> insection(int[][] A,int[][] B){//A,B有序
      int a =0;
      int b =0;
      List<int[]> ans = new ArrayList<>();
      while (a<A.length && b<B.length){
          int left = Math.max(A[a][0],B[b][0]);   //[0]小边界取大值
          int right = Math.min(A[a][1],B[b][1]);  //[1]大边界取小值
          if(left<=right){//如果大于就没有交集
             ans.add(new int[]{left,right});
          }
          if(A[a][1]<B[b][1]){
              a++;
          }else{
              b++;
          }
      }
      return ans;
    }


    public static void main(String[] args) {
        int[][] A ={{0,2},{5,10},{13,23},{24,25}};
        int[][] B ={{1,5},{8,12},{15,24},{25,26}};
        List<int[]> result = insection(A,B);
        System.out.println(JSON.toJSONString(result));
    }
}
