package com.whl.algo.算法分类.排序;

import com.alibaba.fastjson.JSON;

import java.util.*;

/*
* 如 [0,1],[1,2],[2,1] 拓扑有循环依赖
* 通过拓扑排序找到入度为 0 删除,最后空即为无依赖,主要 BFS算法
* */
public class 检测循环依赖 {

    public static boolean topoSort(int n,Integer[][] nums){
        int[] indepgrees = new int[n];
        Stack<Integer> stack = new Stack<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int cur = nums[i][0];
            int next = nums[i][1];
            indepgrees[next]++;//入度
            if(map.containsKey(cur)){
                map.get(cur).add(next);
            }else{
                List<Integer> list = new ArrayList();
                list.add(next);
                map.putIfAbsent(cur,list);
            }
        }
        for(int i=0;i<indepgrees.length;i++){
            if(indepgrees[i]==0){
                stack.push(i);
            }
        }
        while (!stack.isEmpty()){
          int cur =  stack.pop();
          List<Integer> list = map.get(cur);
          if(list!=null){
              for(Integer e:list){
                  indepgrees[e]--;
                  if(indepgrees[e]==0){
                      stack.push(e);
                  }
              }
          }

        }
        for(int i=0;i<indepgrees.length;i++){
            if(indepgrees[i]!=0){
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        Integer[][] nums = {{0,1},{1,2},{2,3}};
        System.out.println(topoSort(4,nums));
        int[] num1 ={1,1};
        int[] num2 ={1,1};
        System.out.println(String.format("num1:%s,num2:%s",num1.hashCode(),num2.hashCode()));
    }
}
