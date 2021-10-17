package com.whl.algo.math;

public class Sqart {
    public static void main(String[] args) {
        int result = mySqrt(64);
        System.out.println(result);
    }

    public static int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
