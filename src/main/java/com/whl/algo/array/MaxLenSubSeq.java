package com.whl.algo.array;

public class MaxLenSubSeq {
    public static void main(String[] args) {

    }

    public static  int maxlenSub(int[] array){
        int start = 0;
        int max=0;
        for(int i=0;i<array.length;i++){
            if(array[i]<array[i-1]){
                start=i;
            }
            max=Math.max(max,i-start+1);
        }
        return max;
    }
}
