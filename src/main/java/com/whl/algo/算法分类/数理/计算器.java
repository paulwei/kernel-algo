package com.whl.algo.算法分类.数理;

import java.util.Stack;

/*
* 输入：s = "(1+(4+5+2)-3)+(6+8)"
* 输出：23
* */
public class 计算器 {

    public static  int caculate(String s){
        int res=0 ;
        int num=0;
        int sign=1;//通过乘以-1 翻转
        Stack<Integer> resStatck=new Stack<>();
        Stack<Integer> signStatck=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c>='0' && c<='9'){//数字
                num=num*10+(c-'0');
            }else if(c=='+' || c=='-'){
                res=res+num*sign;
                num=0;//计算完清零
                if(c=='-'){
                    sign=-1;
                }else{
                    sign=1;
                }
            }else if(c=='('){
                resStatck.push(res);
                signStatck.push(sign);
                num=0;
                sign=1;
                res=0;
            }else if(c==')'){
                res = res + sign*num;
                System.out.println(String.format(") c:%s,res:%s num:%s sign:%s",c,res,num,sign));
                num =0 ;
                res*= signStatck.pop();
                res+= resStatck.pop();
            }

            System.out.println(String.format("c:%s,res:%s",c,res));

        }
        res = res+ sign*num;//计算最后一个数
        return res;
    }

    public static void main(String[] args) {
      String  s = "(1+(4+5+2)-3)+(6+8)";
      int result = caculate(s);
        System.out.println(result);
    }


}
