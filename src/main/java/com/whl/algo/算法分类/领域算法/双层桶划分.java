package com.whl.algo.算法分类.领域算法;
/*
*  分而治之思想多层划分
* 问题1：在2.5亿个整数中找出不重复的整数的个数。假设内存不足以同时容纳2.5亿个整数。
方案1：
整数个数为 2^32，也就是，我们可以将这 2^32 个数，划分为 2^8 个区域（比如2^8 个文件），然后将数据分离到不同的区域，然后不同的区域在利用 bitmap 就可以直接解决了。
方案2：
采用 2-bitmap，每个数分别 2 个bit，00 表示出现 0 次，01 表示出现 1 次，11 表示出现多次。
需要内存 2.5 亿 * 2 = 5亿 bit = 0.5G bit = 0.07G byte = 70M。
依次扫描2.5亿个整数：
00 变 01
01 变 11
10 不变
*
问题2：在5亿个整数中找出中位数。
方案2：将这些数字划分到 2^16 个区域，依次统计每个区域内元素的个数，根据统计结果，判断出中位数位于哪个区域。随后在重新扫描该区域。
*
* */
public class 双层桶划分 {
}
