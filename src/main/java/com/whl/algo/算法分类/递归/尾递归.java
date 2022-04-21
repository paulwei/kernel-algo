package com.whl.algo.算法分类.递归;

/*
* 前面的递归计算称为普通递归，它需要在计算过程中保存值，如代码中的first 和last。
* 我们知道，函数调用参数会保存在栈上，如果递归调用过多，栈会非常深。而内存又是有限
* 的，所以递归存在爆栈的情况。如果这些中间值不单独处理，而是直接传递给递归函数作为
* 参数，在参数传递时先计算，那么栈的内存消耗不会猛增，代码也会更简洁。因为所有参数
* 都放到递归函数里，且函数的最后一行一定是递归，所以又叫尾递归。
* */
public class 尾递归 {
    public static int tailRecSum(int x,int total){
        if (x==0) {
            return total;
        } else {
            return tailRecSum(x-1, total+x);
        }
    }
    public static void main(String[] args) {
        int sum  = tailRecSum(5,0);
        System.out.println(sum);
    }
}
