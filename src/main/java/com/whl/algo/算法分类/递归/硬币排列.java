package com.whl.algo.算法分类.递归;

public class 硬币排列 {
    public static void main(String[] args) {
        int line = arrange(10);
        System.out.println(line);
    }

    public  static int arrange(int n){
        for(int i=1;i<=n;i++){
            n=n-i;//第一行减去1 个,第 i行 减去 i个
            if(n<=i){
                return i;
            }
        }
        return 0;
    }
}
