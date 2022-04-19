package com.whl.algo.算法分类.数理;

import java.util.Random;

public class Rand7实现Rand10 {

    public static int rand10() {

        while(true) {
            // 首先得到一个数[1,7]-1 后 [0,6]
            int num = (rand7() - 1) * 7 + rand7();//[0,42]+[1,7]->[1,49]
            // 只要它还大于10，那就给我不断生成，因为我只要范围在1-10的，最后直接返回就可以了
            if (num <= 40) {
                return num%10+1;
            }
        }
    }

    public static int rand7(){
        return new Random().nextInt(7);
    }

}
