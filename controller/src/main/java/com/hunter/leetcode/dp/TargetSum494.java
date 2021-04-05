package com.hunter.leetcode.dp;

// 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。
// 现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选
// 择一个符号添加在前面。
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
//
//
//
// 示例：
//
// 输入：nums: [1, 1, 1, 1, 1], S: 3
// 输出：5
// 解释：
//
// -1+1+1+1+1 = 3
// +1-1+1+1+1 = 3
// +1+1-1+1+1 = 3
// +1+1+1-1+1 = 3
// +1+1+1+1-1 = 3
//
// 一共有5种方法让最终目标和为3。
//
//
// 提示：
//
//
// 数组非空，且长度不会超过 20 。
// 初始的数组的和不会超过 1000 。
// 保证返回的最终结果能被 32 位整数存下。
//
// Related Topics 深度优先搜索 动态规划
// 👍 623 👎 0

/**
 * 分析：01背包问题
 * 假设加法的总和为x，而减法的总和为y，那么x-y = S
 * 而y = sum-x故，x-(sum - x) = S,所以x = (sum + S)/2
 *
 * @author yanghong
 */
public class TargetSum494 {

    public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int i = 0; i < nums.length; i ++) {
            sum += nums[i];
        }
        if((sum + S) % 2 != 0 || S > sum) {
            return 0;
        }
        int target = (sum + S) / 2;

        int[][] dp = new int[nums.length + 1][target + 1];

        dp[0][0] = 1;
        for(int i = 1; i <= nums.length; i++) {
            for(int j = 0; j <= target; j++) {
                if(j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][target];
    }

    public static void main(String[] args) {

        int[] nums = {1,1,1,1,1};
        int S = 3;
        int result = findTargetSumWays(nums, S);
        System.out.println(result);

    }

}
