package com.hunter.leetcode.dp;

/**
 * 题目描述
 * 给定一个数组，求这个数组中连续且等差的子数组一共有多少个。长度 >= 3
 *
 * 输入输出样例
 * 输入是一个一维数组，输出是满足等差条件的连续字数组个数。
 *
 * Input: nums = [1,2,3,4]
 * Output: 3
 *
 */

public class Slices {

    private static int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        int len = A.length, count = 0, temp = 2,dis = A[1] - A[0];

        boolean flag;

        for (int i = 2; i < len; ) {
            flag = true;

            while (i< len && A[i] - A[i-1] == dis) {
                i++;
                temp++;
                flag = false;
            }
            if (!flag) {
                count += (temp - 1) * (temp - 2) >> 1;
            }
            if (i < len) {
                dis = A[i] - A[i - 1];
                temp = 2;
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        System.out.println(numberOfArithmeticSlices(A));
    }

}
