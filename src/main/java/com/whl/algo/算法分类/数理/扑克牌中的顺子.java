package com.whl.algo.算法分类.数理;
/*
*从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
*桶计数 + 遍历
* 小王可以当任何数,A不能顺
* */
public class 扑克牌中的顺子 {
    public boolean isStraight(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] poker = new int[14];//使用14个桶来对数字进行计数，以判断元素是否重复

        for(int num : nums){
            if(num == 0) continue;// 0 不计入统计最小值的范围内
            if(poker[num] == 1) return false;// 如果出现元素重复了，直接返回false,之前有元素相加
            poker[num]++;
            max = Math.max(max,num);
            min = Math.min(min,num);
        }
        return max - min < 5;
    }

}
