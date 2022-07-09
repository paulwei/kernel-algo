package com.whl.algo.算法分类.递归;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;

/*
* 1 借助目标杆将height - 1 个盘子移动到中间杆
* 2 将最后一个盘子移动到目标杆
* 3 借助起始杆将height-1 个盘子从中间杆移动到目标杆。
*  输入：A = [2, 1, 0], B = [], C = []
*  输出：C = [2, 1, 0]
*  重点：构建模型  A-----> （借助） B ->C
*
* */
public class 汉诺塔 {

    public static void  hanota(int n,LinkedList<Integer> A,LinkedList<Integer> B,LinkedList<Integer> C){
            if(n==1){
                System.out.println("A':"+JSON.toJSONString(A));
                System.out.println("B':"+JSON.toJSONString(B));
                System.out.println("C':"+JSON.toJSONString(C));
                C.add(0, A.remove(0));
                return;
            }

            hanota(n-1,A,C,B);
            System.out.println("A:"+JSON.toJSONString(A));
            System.out.println("B:"+JSON.toJSONString(B));
            System.out.println("C:"+JSON.toJSONString(C));
            C.add(0, A.remove(0));
            hanota(n-1,B,A,C);
    }

    public static void main(String[] args) {
        LinkedList<Integer> A =  new LinkedList<>();
        A.add(2);
        A.add(1);
        A.add(0);
        LinkedList<Integer> B =  new LinkedList<>();
        LinkedList<Integer> C =  new LinkedList<>();
        hanota(A.size(),A,B,C);
        System.out.println("result:"+JSON.toJSONString(C));
    }
}
