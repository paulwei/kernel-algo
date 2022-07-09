package com.whl.algo.算法分类.递归;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/*
* 返回所有长度为 n 且满足其每两个连续位上的数字之间的差的绝对值为 k 的 非负整数 。
请注意，除了 数字 0 本身之外，答案中的每个数字都 不能 有前导零。例如，01 有一个前导零，所以是无效的；但
输入：n = 3, k = 7
输出：[181,292,707,818,929]
解释：注意，070 不是一个有效的数字，因为它有前导零。
*
*
*
*
* */
public class 连续差相同的数字 {

    static List<Integer> res = new ArrayList<>();

    public static int[] numsSameConsecDiff(int n, int k) {
        //先初始化开头第一个字符，进入递归
        for (int i = 1; i <= 9; i++) {
            //如果i+k或者i-k都不是有效的字符，说明当前i不能作为数字的开头
            if (i + k > 9 && i - k < 0)
                continue;
            //进入递归
            DFS(new StringBuilder(String.valueOf(i)), n, k);
        }
        int[] nums = new int[res.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res.get(i);
        }
        return nums;
    }


    public static void DFS(StringBuilder str, int n, int k) {
        //长度到了就进入结果
        if (str.length() == n) {
            res.add(Integer.parseInt(str.toString()));
            return;
        }
        //获取上一个数字是什么
        int num = str.charAt(str.length() - 1) - '0';
        //num+k 可以加入到str中，并且开始递归
        if (num + k < 10) {
            str.append(String.valueOf(num + k));
            DFS(str, n, k);
            str.deleteCharAt(str.length() - 1);
        }
        //num-k 可以加入到str中并且开始递归
        if (num - k >= 0 && k != 0) {
            str.append(String.valueOf(num - k));
            DFS(str, n, k);
            str.deleteCharAt(str.length() - 1);
        }
    }


    public static void main(String[] args) {
        int n=3;int k=7;
        numsSameConsecDiff(n,k);
        System.out.println(JSON.toJSONString(res));
    }
}
