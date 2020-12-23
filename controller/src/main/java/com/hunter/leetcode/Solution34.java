package com.hunter.leetcode;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 你的算法时间复杂度必须是 O(log n) 级别。
//
// 如果数组中不存在目标值，返回 [-1, -1]。
//
// 示例 1:
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4]
//
// 示例 2:
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1]
// Related Topics 数组 二分查找

/**
 * @description:
 * @author: hunter.yang
 * @date: 20201109 13:15
 */
public class Solution34 {

    public static int[] searchRange(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int[] result = new int[]{-1,-1};

        if (nums.length == 0) {
            return result;
        }

        while (start <= end) {

            int mid = (start + end) / 2;

            if (start < 0 || end > nums.length - 1 || mid < 0 || mid > nums.length) {
                break;
            }
            if (nums[mid] == target) {

                int midTemp = mid;
                // 往start找
                while (mid >= start) {
                    if (nums[mid] == target) {
                        result[0] = mid;
                    }
                    if (mid != 0 && nums[mid - 1] == target) {
                        mid = mid - 1;
                        result[0] = mid;
                    }
                    mid = mid - 1;
                }

                mid = midTemp;
                // 往end找
                while (mid <= end) {
                    if (nums[mid] == target) {
                        result[1] = mid;
                    }
                    if (mid != nums.length - 1 && nums[mid + 1] == target) {
                        mid = mid + 1;
                        result[1] = mid;
                    }
                    mid = mid + 1;
                }
                break;
            }
            // 二分查找
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(searchRange(new int[]{8,8,8,8,8}, 8));
    }

}
