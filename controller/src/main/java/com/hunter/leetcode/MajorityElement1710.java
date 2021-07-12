package com.hunter.leetcode;

//数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1
//) 的解决方案。
//
//
//
// 示例 1：
//
//
//输入：[1,2,5,9,5,9,5,5,5]
//输出：5
//
// 示例 2：
//
//
//输入：[3,2]
//输出：-1
//
// 示例 3：
//
//
//输入：[2,2,1,1,1,2,2]
//输出：2
// Related Topics 数组 计数
// 👍 90 👎 0

import java.util.HashMap;

/**
 * @author yanghong
 */
public class MajorityElement1710 {

    public static int majorityElement(int[] nums) {

        HashMap<Integer, Integer> countMap = new HashMap<>();
        int max = 0;
        int maxNum = -1;

        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, count);
            if (max < count) {
                max = count;
                maxNum = num;
            }
        }

        if (max <= nums.length /2) {
            return -1;
        }

        return maxNum;
    }

    public static void main(String[] args) {

        int[] nums = {0};

        System.out.println(majorityElement(nums));

    }
}
