package com.whl.algo.算法分类.数理;

public class 悬挂纸牌 {

    public static int getLeast(double d){
        int n=1;
        double sum=0.5;
        while (sum<d){
            sum+=1/++n;
        }
        return n;
    }
}
