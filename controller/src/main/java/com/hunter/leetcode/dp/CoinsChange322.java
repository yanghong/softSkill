package com.hunter.leetcode.dp;

// 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
// 如果没有任何一种硬币组合能组成总金额，返回
// -1。
//
// 你可以认为每种硬币的数量是无限的。
//
//
// 示例 1：
//
//
// 输入：coins = [1, 2, 5], amount = 11
// 输出：3
// 解释：11 = 5 + 5 + 1
//
// 示例 2：
//
//
// 输入：coins = [2], amount = 3
// 输出：-1
//
// 示例 3：
//
//
// 输入：coins = [1], amount = 0
// 输出：0
//
//
// 示例 4：
//
//
// 输入：coins = [1], amount = 1
// 输出：1
//
//
// 示例 5：
//
//
// 输入：coins = [1], amount = 2
// 输出：2
//
//
//
//
// 提示：
//
//
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104
//
// Related Topics 动态规划
// 👍 1176 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 此题可以使用动态规划来解决，我们定义 dp[i]表示达到i用的最少硬币数，那么状态转移方程为：
 *
 * dp[i] =Math.min(dp[i-coin]+1,dp[i])
 * 其中i为目标金额，dp[i-coin]+1  代表我们用coin金额的硬币。
 *
 * @author yanghong
 */
public class CoinsChange322 {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int j = 1; j < dp.length;j++) {
            dp[j] = amount + 1;
        }

        for (int i = 0; i< dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2};

        int count = coinChange(coins, 3);
        System.out.println(count);
    }
}
