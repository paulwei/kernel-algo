package com.whl.algo.算法分类.单调栈;

import java.util.Stack;

/*
*
* 思路：辅助栈保持从底向上保持降序[和栈顶比较，比栈顶小入栈]，最后获取辅助栈顶元素
* */
public class 最小栈 {

    public static int getMinStack(int[] arr){
        Stack<Integer> stackA = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(stackA.isEmpty() || arr[i] < stackA.peek()){
                stackA.push(arr[i]);
            }
        }
        return stackA.pop();
    }

    public static void main(String[] args) {
        int[] arr ={4,3,10,2,5,1};
        int ans = getMinStack(arr);
        System.out.println(ans);
    }
}
