package com.whl.algo.算法分类.矩阵;

import com.alibaba.fastjson.JSON;

/*
* 螺旋矩阵编号
* */
public class 螺旋矩阵 {

    public  static int[][]  rotate(int[][] maxtrix){
        int i=0,j=0;
        int n = maxtrix.length;
        int num = 1;
        while (num<=n*n) {
            while (j<n){
                if(j==n-1 || maxtrix[i][j+1]==0){
                    maxtrix[i][j]=num++;
                }
            }
            while (i<n){
                if(i==n-1 || maxtrix[i+1][j]==0){
                    maxtrix[i++][j]=num++;
                }
            }
            while (j>=0){
                if(j==1 || maxtrix[i][j-1]==0){
                    maxtrix[i][j--]=num++;
                }
            }
            while (i>=0){
                if(i==1 || maxtrix[i-1][j]==0){
                    maxtrix[i--][j]=num++;
                }
            }
        }
        return maxtrix;
    }

    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            t++;
            for(int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            r--;
            for(int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for(int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        rotate(matrix);
        System.out.println(JSON.toJSONString(matrix));
    }


}
