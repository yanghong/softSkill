package com.hunter.leetcode;

//给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
//
//
//
// 示例 1:
//
// 输入: [1,2,0]
//输出: 3
//
//
// 示例 2:
//
// 输入: [3,4,-1,1]
//输出: 2
//
//
// 示例 3:
//
// 输入: [7,8,9,11,12]
//输出: 1
//
// 输入: [3,2,4,1]
//  [4,2,3,1]
//  []
//
// 提示：
//
// 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
// Related Topics 数组

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/10/27 23:18
 */
public class Solution41 {

    public static int firstMissingPositive(int[] nums) {

        for (int i=0; i< nums.length; i++ ) {

            while (nums[i] > 0
                    && nums[i] != i + 1
                    && nums[i] <= nums.length
                    && nums[nums[i] -1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] -1];
                nums[temp - 1] = temp;
            }

        }

         for (int i = 0; i< nums.length; i++) {
             if (nums[i] != i + 1) {
                 return i + 1;
             }
         }

         return nums.length + 1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
    }
}
