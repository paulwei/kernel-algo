package com.whl.algo.算法分类.二分查找;

public class X平方根 {

    public static int  sqrt(int x){
        int l=0;
        int r = x/2;
        while (l<r){
            int mid = l + (r - l) / 2;  // 直接采用(r+l)/2. 容易出现整形溢出
            double p1= mid*mid;
            double p2= (mid+1)*(mid+1);
            if(x==p1){
                return mid;
            }
            if(x==p2){
                return mid+1;
            }
            if(p1>x){
                r = mid-1;
            }else{
                l=  mid+1;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int x = 16;
        int n = sqrt(x);
        System.out.println(n);
    }
}
