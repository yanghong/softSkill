package com.hunter.leetcode.dp;

//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//
// 示例 1：
//
//
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
//
//
// 示例 2：
//
//
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
//
//
// 示例 3：
//
//
//输入：s = ""
//输出：0
//
// 提示：
//
//
// 0 <= s.length <= 3 * 104
// s[i] 为 '(' 或 ')'
//
//
//
// Related Topics 字符串 动态规划
// 👍 1252 👎 0

/**
 * @author yanghong
 */
public class LongestValidParentheses32 {

    public static int longestValidParentheses(String s) {

        if ("".equals(s) || null == s) {
            return 0;
        }

        int maxLen = 0;
        int pre;

        int[] dp = new int[s.length()];
        dp[0] = 0;

        char[] sCharList = s.toCharArray();

        for (int i = 1; i < sCharList.length;i++) {

            if (')'== sCharList[i]) {
                pre = i - dp[i-1] - 1;
                if (pre >= 0 && sCharList[pre] == '(') {
                    dp[i] = dp[i-1] + 2 + (pre > 0 ? dp[pre-1] : 0);
                }
                maxLen = Math.max(maxLen,dp[i]);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {

        String s = "()";

        int result = longestValidParentheses(s);
        System.out.println(result);
    }
}
