package com.whl.algo.dg;

public class CutRope {
    public static int cutRope(int target) {
        //排除特殊情况
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int[] products = new int[target + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        for (int i = 4; i <= target; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                System.out.println(String.format("i:%s,j:%s i-j:%s",i,j,i-j));
                max = Math.max(max, product);
            }
            System.out.println(String.format("第 products[%s],最大值 max:%s",i,max));
            products[i] = max;
        }
        return products[target];
    }

    public static void main(String[] args) {
        System.out.println(cutRope(8));
    }
}
