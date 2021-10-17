package com.whl.algo.算法分类.树;

/*
* 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字
* 10叉树
* */
public class 字典树第K小 {

    public static long findKth(long n,long k){
        long cur=1;
        k--;
        while(k>0){
            long nodes = getNodesCount(n,k);
            if(k>nodes){
                k=k-nodes;
                cur=cur+1;
            }else{
                k--;
                cur=cur*10;
            }
        }
        return cur;
    }

    public static long getNodesCount(long n,long cur){
        long total=0;
        long next = cur+1;
        while(cur<=n){
            total+=Math.min(n-cur+1,next-cur);
            next*=10;
            cur*=10;
        }
        return total;
    }
}
