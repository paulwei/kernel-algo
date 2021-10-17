package com.whl.algo.算法分类.单调栈;

import java.util.Deque;
import java.util.LinkedList;

/*
* 输入：nums = [3,1,4,2]
* 输出：true
* 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
* 思路:
*
* */
public class 模式132 {
    public boolean find132pattern(int[] nums) {
        int n=nums.length;
        Deque<Integer> stack=new LinkedList<>();//维护一个单调栈，从栈底到栈顶单调非递增
        int numsk=Integer.MIN_VALUE;//记录题目中的nums[k]
        for(int i=n-1;i>=0;i--){//按题目要求，直接满足了i<j<k
            int cur=nums[i];
            if(cur<numsk){//找到13
                return true;
            }
            while(!stack.isEmpty()&&cur>stack.peekFirst()){//找到32,numsk为3，cur为2
                numsk=Math.max(numsk,stack.pollFirst());
            }
            stack.addFirst(cur);
        }
        return false;
    }

}
