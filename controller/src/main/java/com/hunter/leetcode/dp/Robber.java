package com.hunter.leetcode.dp;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述:
 * 假如你是一个劫匪，并且决定抢劫一条街上的房子，每个房子内的钱财数量各不相同。如果
 * 你抢了两栋相邻的房子，则会触发警报机关。求在不触发机关的情况下最多可以抢劫多少钱。
 *
 * 输入输出样例:
 * 输入是一个一维数组，表示每个房子的钱财数量；输出是劫匪可以最多抢劫的钱财数量。
 *
 * input:[2,7,9,3,1]
 * output:12
 */
public class Robber {

    private static Integer rob(List<Integer> nums) {
        if (null == nums || nums.size() == 0) {
            return 0;
        }

        int n = nums.size();
        List<Integer> dp = new ArrayList<>();
        for (int l = 0; l<= n+1; l++) {
            dp.add(0);
        }
        dp.set(1, nums.get(0));
        for (int i = 2; i <= n; ++i) {
            dp.set(i, Math.max(dp.get(i-1), nums.get(i-1)+dp.get(i-2)));
        }
        return dp.get(n);
    }

    public static void main(String[] args) {
        List<Integer> nums = Lists.newArrayList(2,7,9,3,1);
        System.out.println(rob(nums));
    }
}
