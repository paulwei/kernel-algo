package com.whl.algo.算法分类.并查集;

import com.alibaba.fastjson.JSON;

/*
* 省份数量或者朋友圈
* 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
* 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
* 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
* 返回矩阵中 省份 的数量
* 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
*
* 1,1,0
* 1,1,0
* 0,0,1
*
* 输出：2
* 思路:合并集 parent:[1,1,2],坐标 0 和 1 一个集合,2 一个集合  isConnected[i][j] = 1 parent[j]位置和 parent[i] 值一样
* */
public class 省份数量 {
    public static int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        int[] parent = new int[provinces];
        for (int i = 0; i < provinces; i++) {
            parent[i] = i;
        }
        System.out.println("parent:"+JSON.toJSONString(parent));
        for (int i = 0; i < provinces; i++) {
            for (int j = i + 1; j < provinces; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        System.out.println(String.format("parent:%s",JSON.toJSONString(parent)));

        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (parent[i] == i) {//parent:[1,1,2]
                circles++;
            }
        }
        return circles;
    }

    public static void union(int[] parent, int index1, int index2) {
        System.out.println(String.format("union index1:%s index1:%s",index1,index2));
        parent[find(parent, index1)] = find(parent, index2);//parent:[1,1,2]找到根点值赋值为当前
    }

    public static int find(int[] parent, int index) {
        if (parent[index] != index) {
            return find(parent, parent[index]);//一直往下找到最开始存储值,追溯根值,合并操作也是很简单的，先找到两个集合的代表元素，然后将前者的父节点设为后者即可。当然也可以将后者的父节点设为前者，这里暂时不重要
        }
        System.out.println(String.format("parent[%s]:%s",index,parent[index]));
        return parent[index];
    }

    public static void main(String[] args) {
        int[][] isConnected={{1,1,0},{1,1,1},{0,0,1}};
        int result = findCircleNum(isConnected);
        System.out.println(result);
        System.out.println();
    }

}
