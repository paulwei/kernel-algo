package com.whl.algo.算法分类.抽屉原理;

public class 有序数列缺失数 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,5};
        miss(nums);
    }

    public static void miss(int[] nums){
        int[] home=new int[5];
        for(int n:nums){
            if( home[n-1]==0){
                home[n-1]=n;
            }else{
                System.out.println("repeat:"+n);
            }
        }
        for(int i=0;i<home.length;i++){
            if(home[i]==0){
                System.out.println("miss:"+(i+1));
            }

        }
    }
}
