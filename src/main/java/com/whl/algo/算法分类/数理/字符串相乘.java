package com.whl.algo.算法分类.数理;

/*
*
*
* 思路：将两个字符串转成数组，数组中数字遍历相乘得到长数组，解决进位问题，最后转成字符串；

 * */
public class 字符串相乘 {
    public String multiply(String num1, String num2) {
        //解题思路：将两个字符串转成数组，数组中数字遍历相乘得到长数组，解决进位问题，最后转成字符串；
        String zero = "0";
        if(zero.equals(num1) || zero.equals(num2)){
            return zero;
        }
        int m = num1.length();
        int n = num2.length();
        int[] res =  new int[m + n];
        int x = 0;
        int y = 0;
        for(int i = 0; i < m; i++){
            x = num1.charAt(i) - '0';
            for(int j = 0; j < n; j++){
                y = num2.charAt(j) - '0';
                res[i + j + 1] += x * y;
            }
        }

        //从后往前解决进位问题
        int k = m + n - 1;
        while(k != 0){
            if(res[k] >= 10){
                res[k -1] += res[k] / 10;
                res[k] = res[k] % 10;
            }
            k--;
        }
        //组装结果
        StringBuilder sb = new StringBuilder();
        int start = res[0] == 0 ? 1 : 0;
        for(int i = start; i < res.length; i++){
            sb.append(String.valueOf(res[i]));
        }
        return sb.toString();
    }

}
