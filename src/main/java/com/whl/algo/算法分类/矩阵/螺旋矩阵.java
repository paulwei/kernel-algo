package com.whl.algo.算法分类.矩阵;

import com.alibaba.fastjson.JSON;

/*
* 螺旋矩阵编号
* 解题思路：四条边界 top right down left
* i,j 坐标 局部定义
* j++循环,top+1; i++循环,right-1; j--循环,down-1; i--循环,left+1;
 *
*
* */
public class 螺旋矩阵 {
    public  static void  rotate(int[][] matrix){
        int left = 0;
        int right = matrix.length-1;
        int top = 0;
        int down = matrix.length-1;
        int num=1;
        while (true){
            for(int i=left;i<=right;i++){
                matrix[top][i]=num++;
            }
            top++;
            if (top > down) break;
            for(int i=top;i<=down;i++){
                matrix[i][right]=num++;
            }
            right--;
            if (left > right) break;
            for(int i=right;i>=left;i--){
                matrix[down][i]=num++;
            }
            down--;
            if (top > down) break;
            for(int i=down;i>=top;i--){
                matrix[i][left]=num++;
            }
            left++;
            if (left > right) break;
        }
    }

    public static void init(int[][] arr) {
        int val = 1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]=val++;
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
//        init(matrix);
//        System.out.println(JSON.toJSONString(matrix));
        rotate(matrix);
        System.out.println(JSON.toJSONString(matrix));
    }


}
