package com.whl.algo.算法分类.数理;

/*
* 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
* 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
* 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
* 输入:
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]
输出: 3
* 思路:剩余量最少的,下一个才可能
*
*
* */
public class 加油站 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            System.out.println(String.format("i:%s, spare:%s",i,spare));
            if (spare < minSpare) {//最小欠的油最多,下一个开始少的地方开始
                minSpare = spare;
                minIndex = i;
            }
        }

        return spare < 0 ? -1 : (minIndex + 1) % len;
    }

    public static void main(String[] args) {
        int[] gas ={1,2,3,4,5};
        int[] cost ={3,4,5,1,2};
        int result = canCompleteCircuit(gas,cost);
        System.out.println(result);
    }
}
