package com.hunter.leetcode;

//给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：6
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3,4]
//输出：24
//
//
// 示例 3：
//
//
//输入：nums = [-1,-2,-3]
//输出：-6
//
//
//
//
// 提示：
//
//
// 3 <= nums.length <= 104
// -1000 <= nums[i] <= 1000
//
// Related Topics 数组 数学
// 👍 304 👎 0

import java.util.Arrays;

/**
 * @author yanghong
 */
public class ThreeNumMutile628 {

    public static int maximumProduct(int[] nums) {

        int length = nums.length;

        if (length <3) {
            return 0;
        }

        Arrays.sort(nums);

        return Math.max(nums[length - 1]*nums[length - 2]*nums[length - 3], nums[0] * nums[1] * nums[length - 1]);

    }

    public static void main(String[] args) {

        int[] nums = {-100,-98,-1,2,3,4};

        System.out.println(maximumProduct(nums));

    }
}
