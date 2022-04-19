package com.whl.algo.算法分类.二分查找;

public class 第一错误版本 {
    int firstBadVersion(int n) {
        // 直接二分即可,找到第一个为false的版本
        // 全闭区间
        int l = 1, r = n;
        while (l <= r){
            int mid = l + (r - l) /2 ;
            if (isBadVersion(mid))
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }

    private boolean isBadVersion(int mid) {
        return mid==3;
    }



}
