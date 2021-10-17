package com.whl.algo.算法分类.并查集;

import com.alibaba.fastjson.JSON;

/*
*   int n = 5; //5人
    int m = 3; //三对好友关系
    int r[3][2] = { { 1, 2 }, { 2, 3 }, { 4, 5 } };
    输出朋友圈:2  {1,2,3} {4,5}
*   fa [1,2,3,4,5] --> [1,1,1,4,4]
* */
public class 朋友圈 {

    public static int findCircle(int[][] r){//关系
        int cricles=0;
        int n=5;
        int m=3;
        int[] fa=new int[n+1];
        for(int i=0;i<fa.length;i++){
            fa[i]=i;
        }
        for(int i=0;i<m;i++){
           int x= r[i][0];
           int y= r[i][1];
           merge(fa,x,y);
        }
        System.out.println(JSON.toJSONString(fa));
        for(int i=1;i<fa.length;i++){
            if(fa[i]==i){//几个祖先节点
                cricles++;
            }
        }
        return cricles;
    }

    public static void merge(int[] fa,int x,int y){//x,y 值
          int xv= find(fa,x);//x祖先值
          int yv= find(fa,y);//y祖先值
          fa[yv]=fa[xv];//y 祖先值用 x祖先值覆盖并集
//         fa[xv]=fa[yv];
    }

    public static int find(int[] fa,int x){
        if(x==fa[x]){
            return x;
        }
       return find(fa,fa[x]);
    }

    public static void main(String[] args) {
        int[][] r= { { 1, 2 }, { 2, 3 }, { 4, 5 } };
        int result = findCircle(r);
        System.out.println(result);
    }

}
