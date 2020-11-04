package com.hunter.leetcode;

//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
//
//
// 说明：
//
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//
//
//
//
// 示例：
//
//
//输入：
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出：[1,2,2,3,5,6]
//
//
//
// 提示：
//
//
// -10^9 <= nums1[i], nums2[i] <= 10^9
// nums1.length == m + n
// nums2.length == n
//
// Related Topics 数组 双指针

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/11/4 21:30
 */
public class Solution88 {

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {

        int pos = m-- + n-- -1;

        while (m>=0 && n>=0) {
            nums1[pos--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }

        while (n >= 0) {
            nums1[pos--] = nums2[n--];
        }
        return nums1;
    }

    public static void main(String[] args) {
        System.out.println(merge(new int[]{0}, 0,new int[]{1}, 1));;
    }
}
