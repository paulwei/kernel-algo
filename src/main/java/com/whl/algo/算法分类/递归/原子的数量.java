package com.whl.algo.算法分类.递归;

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
* 思路压栈更好处理 作废
* */
@Deprecated
public class 原子的数量 {

    public static Stack<Character> s1 = new Stack();
    public static Stack<Map<Character,Integer>> s2 = new Stack();


    public static Map<Character,Integer> recusive(String formula,int i){
        Map<Character,Integer> counter = new HashMap<>();
        Map<Character,Integer> pre=null;
        for(int index=i;index<formula.length();index++) {
            Character c = formula.charAt(index);
            System.out.println("char:" + c);
            if(c>'0' && c<'9'){
              int m = c-'0';
                if(!s1.isEmpty()){
                    Character p= s1.pop();
                    if(")".equalsIgnoreCase(String.valueOf(p))){
                        multiMap(pre,m);
                        addtiMap(pre,counter);
                    }else{
                        counter.put(p,m*(counter.getOrDefault(p,0)+1));
                    }
                }
            }else  if("(".equalsIgnoreCase(String.valueOf(c))){//遇到左括号递归
                pre =  recusive(formula,++index);
            }else if(")".equalsIgnoreCase(String.valueOf(c))){//遇到左括号递归
                s1.push(c);
                return counter;
            }else{
                if(!s1.isEmpty()){
                    Character p= s1.pop();
                    counter.put(p,counter.getOrDefault(p,0)+1);
                }
                s1.push(c);
            }
            addtiMap(pre,counter);
        }
        return counter;
    }

//   public static Map<Character,Integer> counter = new HashMap<>();
//
//    public static Map<Character,Integer> stack(String formula){
//        for(int index=0;index<formula.length();index++){
//                Character c = formula.charAt(index);
//                System.out.println("char:"+c);
//                if(c>'0' && c<'9'){
//                    counter = s2.peek();
//                    multiMap(counter,c-'0');
//                }else  if("(".equalsIgnoreCase(String.valueOf(c))){//遇到左括号递归
//                    s2.push(counter);
//                    counter = new HashMap<>();
//                    if(!s1.isEmpty()){
//                        Character p= s1.pop();
//                        counter.put(p,counter.getOrDefault(p,0)+1);
//                        System.out.println(JSON.toJSONString(counter));
//                    }
//
//                }else if(")".equalsIgnoreCase(String.valueOf(c))){//遇到左括号递归
//                 return counter;
//                }else{
//                    if(!s1.isEmpty()){
//                        Character p= s1.pop();
//                        counter.put(p,counter.getOrDefault(p,0)+1);
//                    }
//                  s1.push(c);
//                }
//            System.out.println(JSON.toJSONString(counter));
//
//        }
//        return counter;
//    }
//    public static Map<Character,Integer> stack(String formula,int i){
//        Map<Character,Integer> counter = new HashMap<>();
//        for(int index=i;index<formula.length();index++){
//                Character c = formula.charAt(index);
//                System.out.println("char:"+c);
//                if(c>'0' && c<'9'){
//                    if(!s1.isEmpty()){
//                        Character p= s1.pop();
//                        counter.put(p,(c-'0'));
//                    }
//                }else  if("(".equalsIgnoreCase(String.valueOf(c))){//遇到左括号递归
//                    if(!s1.isEmpty()){
//                        Character p= s1.pop();
//                        counter.put(p,counter.getOrDefault(p,0)+1);
//                        System.out.println(JSON.toJSONString(counter));
//                    }
//                     addtiMap(stack(formula,index+1),counter);
//                }else if(")".equalsIgnoreCase(String.valueOf(c))){//遇到左括号递归
//                 return counter;
//                }else{
//                    if(!s1.isEmpty()){
//                        Character p= s1.pop();
//                        counter.put(p,counter.getOrDefault(p,0)+1);
//                    }
//                  s1.push(c);
//                }
//            System.out.println(JSON.toJSONString(counter));
//
//        }
//        return counter;
//    }

//    public static Map<Character,Integer> split2(String formula, int index){
//            Map<Character,Integer> counter = new HashMap<>();
//            if(index>=formula.length()){
//                return counter;
//            }
//            Character c = formula.charAt(index);
//           System.out.println(c);
//            if(c>'0' && c<'9'){
//                Map<Character,Integer> tmp = split(formula,index+1);
//                multiMap(tmp,c-'0');
//                return tmp;
//            }else  if("(".equalsIgnoreCase(String.valueOf(c))){//遇到左括号递归
//                return split(formula,index+1);
//            }else if(")".equalsIgnoreCase(String.valueOf(c))){//遇到左括号递归
//                return    split(formula,index+1);
//            }else{
//                counter.put(c,counter.getOrDefault(c,1));
//                Map<Character,Integer> tmp = split(formula,index+1);
//                return   addtiMap(counter,tmp);
//            }
//    }

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
        Map<Character,Integer>  map = recusive(formula,0);
        System.out.println(JSON.toJSONString(map));


    }
}
