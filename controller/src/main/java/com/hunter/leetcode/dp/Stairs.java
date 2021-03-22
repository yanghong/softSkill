package com.hunter.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述：
 * 给定n节台阶，每次可以走一步或者两步，求一共有多少种方式可以走完这个台阶。
 *
 * 输入输出样例:
 * 输入是一个数字，表示台阶数量；输出是爬台阶的总方式。
 *
 * 题解：这是十分经典的斐波那契数列题。定义一个数组dp,dp[i]表示走到第i阶的方法数。因为我们每次可以走一步或者两步。
 * 所以第i阶可以从第i-1或i-2阶到达。换句话说，走到第i阶的方法即为走到第i-1阶的方法数加上走到第i-2阶的方法数。
 * 这样我们就得到了状态转移方程dp[i]=dp[i-1]+dp[i-2].注意边界条件的处理。
 */

public class Stairs {

    private  static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        System.out.println(n);
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {
        int n = 40;
        // 165580141
        System.out.println(climbStairs(n));
    }

}
