package com.whl.algo.算法分类.单调栈;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
* 给你一个字符串化学式 formula ，返回 每种原子的数量 。
输入：formula = "K4(ON(SO3)2)2"   ON(SO3)2
输出："K4N2O14S4"
解释：原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/number-of-atoms
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* 思路压栈更好处理
* */
public class 原子的数量 {

    public static Stack<Map<Character,Integer>> mapStack = new Stack();
    public static Stack<Map<Character, Integer>> doubleStack(String formula){
        Character pre = null;
        for(int index=0;index<formula.length();index++) {
            Character c = formula.charAt(index);
            System.out.println("char:" + c+",pre:"+pre);
            if(c>'0' && c<'9'){
                Map<Character, Integer>  eMap =  mapStack.pop();
                if(eMap!=null){
                    if(")".equalsIgnoreCase(String.valueOf(pre))){
                        multiMap(eMap,c-'0');
                    }else{
                        eMap.put(pre,(c-'0')*eMap.getOrDefault(pre,1));
                    }
                    mapStack.push(eMap);
                }
            }else  if("(".equalsIgnoreCase(String.valueOf(c))){//遇到左括号递归
                Map<Character, Integer> eMap = new HashMap<>();
                mapStack.push(eMap);
            }else if(")".equalsIgnoreCase(String.valueOf(c))){//遇到左括号递归
                pre = c;
                continue;
            }else{
                Map<Character, Integer>  eMap;
                if(!mapStack.isEmpty()){
                    eMap =  mapStack.pop();
                    eMap.put(c,eMap.getOrDefault(c,0)+1);
                }else{
                    eMap = new HashMap<>();
                    eMap.put(c,eMap.getOrDefault(c,0)+1);
                }
                mapStack.push(eMap);
            }
            pre = c;
        }
        return mapStack;
    }


    public static void multiMap(Map<Character,Integer> tmp,int num){
        for(Character c: tmp.keySet()){
            tmp.put(c,tmp.getOrDefault(c,1)*num);
        }
        return;
    }

    public static Map<Character,Integer>  addtiMap(Map<Character,Integer> tmp,Map<Character,Integer> counter){
        if(tmp==null){
            return counter;
        }
        for(Character c: tmp.keySet()){
            counter.put(c,counter.getOrDefault(c,0)+tmp.getOrDefault(c,0));
        }

        return counter;
    }

    public static void main(String[] args) {
//         String formula = "K4(ON(SO3)2)2";
        String formula = "ON(SO3)2";
        Stack<Map<Character, Integer>> stackMap = doubleStack(formula);
        System.out.println(JSON.toJSONString(stackMap));


    }
}
