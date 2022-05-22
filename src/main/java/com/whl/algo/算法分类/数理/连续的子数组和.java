package com.whl.algo.算法分类.数理;

import java.util.HashMap;
import java.util.Map;

/*
* 子数组大小 至少为 2 ，且子数组元素总和为 k 的倍数。
* 输入：nums = [23,2,4,6,7], k = 6
* 输出：true
* 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
* 思路：(a+b)%k = (a%k + b)%k 前缀和+哈希
* 同余定理：即当两个数除以某个数的余数相等，那么二者相减后肯定可以被该数整除 (a+b)%k=((a%k)+b)%k=(a+(b%k))%k=((a%k)+(b%k))%k
* 两个 连续子数组前缀和 相同 的 区间，其之间的连续子数组 为 目标值的倍数
* 根据 modmod 运算的性质，我们知道 (sum[j] - sum[i])\%k = sum[j]\%k - sum[i]\%k(sum[j]−sum[i])%k=sum[j]%k−sum[i]%k。
* 故若想 (sum[j] - sum[i])\%k = 0(sum[j]−sum[i])%k=0，则必有 sum[j]\%k = sum[i]\%ksum[j]%k=sum[i]%k。
* */
public class 连续的子数组和 {
    public static boolean checkSubarraySum(int[] nums, int k) {
        int m = nums.length;
        if (m < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            sum = sum + nums[i];
            sum = sum%k;
            System.out.println(sum+":"+i);
            if (map.containsKey(sum)) {
                cnt++;
                if (cnt >= 2) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }


    public int subarraySum(int[] nums, int k) {
        //前缀和数组
        int[] presum = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            //这里需要注意，我们的前缀和是presum[1]开始填充的
            presum[i+1] = nums[i] + presum[i];
        }
        //统计个数
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i; j < nums.length; ++j) {
                //注意偏移，因为我们的nums[2]到nums[4]等于presum[5]-presum[2]
                //所以这样就可以得到nums[i,j]区间内的和
                if (presum[j+1] - presum[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr =  {23,2,4,6,7}; int k = 6;
        boolean ans = checkSubarraySum(arr,k);
        System.out.println(ans);
    }
}
