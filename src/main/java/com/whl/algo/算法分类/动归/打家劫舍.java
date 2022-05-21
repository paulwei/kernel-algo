package com.whl.algo.算法分类.动归;
/*
*
* 输入：[2,7,9,3,1]
* 输出：12
*  解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
   偷窃到的最高金额 = 2 + 9 + 1 = 12 。
* 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警
* */
public class 打家劫舍 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 子问题：
        // f(k) = 偷 [0..k) 房间中的最大金额

        // f(0) = 0
        // f(1) = nums[0]
        // f(k) = max{ rob(k-1), nums[k-1] + rob(k-2) }

        int N = nums.length;
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int k = 2; k <= N; k++) {
            dp[k] = Math.max(dp[k-1], nums[k-1] + dp[k-2]);
        }
        return dp[N];
    }
}
