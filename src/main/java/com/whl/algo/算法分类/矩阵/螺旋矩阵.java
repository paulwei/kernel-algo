package com.whl.algo.算法分类.矩阵;

import com.alibaba.fastjson.JSON;

/*
* 螺旋矩阵编号
* */
public class 螺旋矩阵 {

    public  static int[][]  rotate(int[][] maxtrix){
        int N= maxtrix.length;
        int num =1;
        for(int n=0;n<N/2;n++){
            for(int j=n;j<N-n-1;j++){//向右
                maxtrix[n][j]=num++;
            }
            for(int j=n;j<N-n-1;j++){//向下
                maxtrix[n][N-n-1]=num++;
            }
            for(int j=N-n-1;j>=n+1;j--){//向左
                maxtrix[N-n-1][j]=num++;
            }
            for(int j=N-n-1;j>=n+1;j--){//向上
                maxtrix[j][n]=num++;
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
