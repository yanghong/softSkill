package com.hunter.leetcode;

//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
// 示例 1:
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
//
//
// 示例 2:
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4
//
// 说明:
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
// Related Topics 堆 分治算法

import java.util.*;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/12/15 19:06
 */
public class Solution215 {

    public static int findKthLargest(int[] nums, int k) {
        if (k > nums.length || k < 1) {
            return 0;
        }

        if (nums.length == 1 && k == 1) {
            return nums[k - 1];
        }

        List<Integer> numSortList = new ArrayList<>();

        for (Integer i : nums) {
            numSortList.add(i);
        }

        numSortList.sort((o1, o2) -> o1 - o2);

        if (k <= numSortList.size()) {
            return numSortList.get(numSortList.size() - k);
        } else {
            return 0;
        }
    }


    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{2,1}, 2));
    }

}
