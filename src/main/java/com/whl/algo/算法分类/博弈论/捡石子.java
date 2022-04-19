package com.whl.algo.算法分类.博弈论;

/*
* 博弈论:输赢问题
* 你和你的朋友正在玩下面的Nim游戏：桌子上有一堆石头，每次你轮流去除1到3块石头。 移除最后一块石头的人将成为赢家。 你是第一个取出石块的。
* 你们两个都非常聪明，并且拥有最佳的游戏策略。 编写一个函数来确定你是否可以在堆中的石头数量的情况下赢得游戏。例如：
* 输入：4
* 输出：false
* 说明：如果堆中有4块石头，那么你永远不会赢得游戏;无论你删除了1,2或3块石头，你的朋友都能去除它。
* */
public class 捡石子 {
    public static boolean canWinNim(int n) {
        if (n <= 4) {
            return n == 1 || n == 2 || n == 3;
        }
        return n%4 != 0;
    }
    public static void main(String[] args) {
        int n=4;
       boolean win = canWinNim(n);
        System.out.println(win);
    }
}
