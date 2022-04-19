package com.whl.algo.算法分类.数理;

/*
*输入：arr = [17,18,5,4,6,1]
*输出：[18,6,6,6,1,-1]
*思路:逆序每次获取最大元素保存在当前位置,
* */
public class 将每个元素替换为右侧最大元素 {
    public static int[] replateRightMax(int[] arr){
        int n = arr.length;
        int rightmax=arr[n-1];
        arr[n-1]=-1;
        for(int i=n-2;i>=0;i--){
            int t= arr[i];
            arr[i]=rightmax;
            if(t>=rightmax){
                rightmax=t;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {17,18,5,4,6,1};

    }
}
