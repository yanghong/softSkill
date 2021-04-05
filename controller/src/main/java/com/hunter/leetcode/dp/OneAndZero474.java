package com.hunter.leetcode.dp;

// 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
//
//
// 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
//
// 如果x的所有元素也是y的元素，集合x是集合y的子集 。
//
// 示例 1：
//
// 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
// 输出：4
// 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
// 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于
// n 的值 3 。
//
//
// 示例 2：
//
//
// 输入：strs = ["10", "0", "1"], m = 1, n = 1
// 输出：2
// 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
//
// 提示：
//
//
// 1 <= strs.length <= 600
// 1 <= strs[i].length <= 100
// strs[i] 仅由 '0' 和 '1' 组成
// 1 <= m, n <= 100
//
// Related Topics 动态规划
// 👍 372 👎 0

/**
 * @author yanghong
 */
public class OneAndZero474 {

    public static int findMaxForm(String[] strs, int m, int n) {

        if (null == strs || m <= 0 || n <= 0) {
            return 0;
        }

        int[][] dp = new int[m + 1][n + 1];

        // 遍历所有的字符串
        for (String str : strs) {

            int ones = 0;
            int zeros = 0;

            for (char c : str.toCharArray()) {
                if ('0' == c) {
                    zeros++;
                } else {
                    ones++;
                }
            }

            for (int i = m;i >= zeros;i--) {
                for (int j = n; j>=ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {

        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        int result = findMaxForm(strs, m, n);
        System.out.println(result);

    }

}
