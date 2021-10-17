package com.whl.algo.算法分类.差分数组;

import com.alibaba.fastjson.JSON;

/*
输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
输出：[10,55,45,25,25]
解释：
航班编号        1   2   3   4   5
预订记录 1 ：   10  10
预订记录 2 ：       20  20
预订记录 3 ：       25  25  25  25
总座位数：      10  55  45  25  25
因此，answer = [10,55,45,25,25]
初始化 int[] d = new int[n]; (全是0)
  航班编号           0    1   2   3   4
      预订记录 1 ：       10  10
      预订记录 2 ：       20  20
      预订记录 3 ：       25  25  25  25
初始差分数组d:       0    0    0    0   0
经过记录1操作之后    10    0   -10   0   0
经过记录2操作之后:   10    20  -10  -20  0
经过记录3操作之后:   10    45  -10  -20  0
获得原数组：        10    55   45   25  25
arr[i]=arr[i-1]+diff[i]
* */
public class 航班预订统计 {
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        for (int[] booking : bookings) {
            nums[booking[0] - 1] += booking[2];
            if (booking[1] < n) {//超过递减
                nums[booking[1]] -= booking[2];
            }
            System.out.println(String.format("booking:%s,nums:%s",JSON.toJSONString(booking),JSON.toJSONString(nums)));  ;
        }
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
       int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
       int[] result = corpFlightBookings(bookings,5);
        System.out.println(JSON.toJSONString(result));
    }

}
