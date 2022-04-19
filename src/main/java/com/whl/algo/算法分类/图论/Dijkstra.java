package com.whl.algo.算法分类.图论;

import com.alibaba.fastjson.JSON;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
* Dijkstra(迪杰斯特拉)算法是求一个顶点到其他所有顶点的最短路径，是单源最短路
* 迪杰斯特拉算法
* Dijkstra一般的表述通常有两种方式，一种用永久和临时标号方式，一种是用OPEN, CLOSE表方式
* 用OPEN,CLOSE表的方式，其采用的是贪心法的算法策略，大概过程如下：
1.声明两个集合，open和close，open用于存储未遍历的节点，close用来存储已遍历的节点
2.初始阶段，将初始节点放入close，其他所有节点放入open
3.以初始节点为中心向外一层层遍历，获取离指定节点最近的子节点放入close并从新计算路径，直至close包含所有子节点
*
* 北京到海南距离
*
* */
public class Dijkstra {
    static class node
    {
        int x; //节点编号
        int lenth;//距离
        public node(int x,int lenth) {
            this.x=x;
            this.lenth=lenth;
        }
    }

    public static void main(String[] args) {
        int[][] map = new int[4][4];//记录权值，顺便记录链接情况，可以考虑附加邻接表
        initmap(map);//初始化
        boolean bool[]=new boolean[4];//判断是否已经确定
        int len[]=new int[4];//长度
        for(int i=0;i<4;i++) {
            len[i]=Short.MAX_VALUE;//加之前路程防止溢出
        }
        Queue<node> q1=new PriorityQueue<node>(com);
        len[0]=0;//从0这个点开始
        q1.add(new node(0, 0));
        int count=0;//计算执行了几次dijkstra
        while (!q1.isEmpty()) {
            node t1=q1.poll();
            int index=t1.x;//节点编号
            int length=t1.lenth;//节点当前点距离
            bool[index]=true;//抛出的点确定
            count++;//其实执行了4次就可以确定就不需要继续执行了  这句可有可无，有了减少计算次数
            for(int i=0;i<map[index].length;i++)
            {
                if(map[index][i]>0&&!bool[i])
                {
                    node node=new node(i, length+map[index][i]);
                    if(len[i]>node.lenth)//需要更新节点的时候更新节点并加入队列
                    {
                        len[i]=node.lenth;
                        System.out.println(i+":"+len[i]);
                        q1.add(node);
                    }
                }
            }
        }
        System.out.println("count:"+count);
        for(int i=0;i<4;i++) {
            System.out.println(len[i]);
        }
    }
    static Comparator<node> com=new Comparator<node>() {
        public int compare(node o1, node o2) {
            return o1.lenth-o2.lenth;
        }
    };

    private static void initmap(int[][] map) {
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                map[i][j]=Short.MAX_VALUE;//加之前路程防止溢出
            }
        }
        map[0][1]=500;map[0][2]=100;map[2][1]=300;map[1][3]=200;
        System.out.println(JSON.toJSONString(map));
    }
}
