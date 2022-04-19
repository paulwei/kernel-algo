package com.whl.algo.算法分类.滑动窗口;

public class 滑动窗口最大平均数 {

    public static void main(String[] args) {
        int[] array = {3,2,5,7,6,4};
        int maxAvg  = findMaxAvg(array,2);
        System.out.println(maxAvg);
    }

    public static int findMaxAvg(int[] array ,int k){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            sum+=array[i];//K个数之和
        }
        for(int i=k;i<array.length;i++){
            sum = sum-array[i-k]+array[i];//
            max = Math.max(sum,max);
        }
        return max/k;
    }
}
