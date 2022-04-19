package com.whl.algo.算法分类.单调栈;

import java.util.Stack;

/*
* 所有子集,区间最小数*区间数和
*[6,2,1]，对于任意子序列可以计算一个X值，X=sum(subArray) * min(subArray)，求最大X
*[6]=6*6
*[2]=2*2
*[6,2]=(6+2)*2
*[6,2,5,5,5,4,7] sum结果:104
*结题思路:迭代每个值作为最小值,然后尽可能向左右延伸(左右均大于该值索引),然后求最大乘积
* */
public class 区间最小数乘区间和的最大值 {

    /*暴力解法*/
    public static int maxProductForce(int[] nums){
        int max = Integer.MIN_VALUE;
        int len = nums.length;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                int sum=0;
                int min=Integer.MAX_VALUE;
               for(int k=i;k<=j;k++){
                    sum+=nums[k];
                    min = Math.min(min,nums[k]);
               }
               max = Math.max(max,sum*min);
            }
        }
        return max;
    }

    /**
     * [6,2,5,5,5,4,7] sum结果:104
     * 单调栈
     * 枚举该值,大于该值入栈,小于该值,当前栈中元素
     * 1. 以数组中每一个值为最小值，假设这个最小值为num[k], 分别找到以该值num[k]为最小值，数组最左边的小于该值的下标i，和数组最右边的小于该值的下标j,
     *    则区间num[i+1,j-1]为以num[k]为最小值所能达到的最大区间，则此区间能达到的最大值为num[k]*Sum(i+1,j-1),其中Sum函数为数组中区间[i+1,j+1]的所有数的和
     *
     */
    public static int largestRectangleArea2(int[] nums){
        return 0;
    }

    public static int largestRectangleArea(int[] num) {
        Stack<Integer> s=new Stack<Integer>();
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int n = num.length;
        for (int i = 0; i<n; i++) {
            if (s.empty() || num[i] >=num[s.peek()]) {//规则1
                System.out.println(String.format("大于栈顶或者 push i:%s ",i));
                s.push(i);
            }else{
                while (!s.empty() && num[s.peek()] >=num[i]) {//规则2
                    int top = s.peek();
                    System.out.println(String.format("小于栈顶 i:%s,top:%s",i,s.peek()));
                    s.pop();
                    int tmp=s.empty()? vecSum(num, 0, i-1) : vecSum(num, s.peek()+ 1, i - 1);
                    int curSum = num[top]*tmp;
                    System.out.println(String.format("最小:%s,curSum:%s maxSum:%s",num[top],curSum,maxSum));
                    maxSum = Math.max(curSum, maxSum);
                }
                s.push(i);
                System.out.println(String.format("小于栈顶 push i:%s,top:%s",i,s.peek()));
            }
        }
        while (!s.empty()) {//规则2
            int top = s.peek();
            s.pop();
            int tmp=s.empty()? vecSum(num, 0, n-1) : vecSum(num, s.peek()+ 1, n - 1);
            int curSum = num[top]*tmp;
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }

    public static int vecSum(int[] num,int i,int j){
        int sum=0;
        for (int k = i; k <= j; k++) {
            sum += num[k];
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] nums = {6,2,5,5,5,4,7};
        int result = largestRectangleArea(nums);
        System.out.println(result);
    }
}
