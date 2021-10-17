package com.whl.algo.array;
//滑动窗口最大平均数
public class maxAvgArray {
    public static void main(String[] args) {

    }

    public int findMaxAvg(int[] array ,int k){
        Integer sum = 0;
        for(int i=0;i<k;i++){
            sum+=array[i];
        }
        int max = sum;
        for(int i=k;i<array.length;i++){
            sum=sum-array[i-k]+array[i];
            sum = Math.max(sum,max);
        }
        return sum/k;
    }
}
