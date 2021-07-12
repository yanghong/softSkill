package com.hunter.leetcode;
//给定两个数组，编写一个函数来计算它们的交集。
//
// 示例 1：
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
// 输出：[2]
//
// 示例 2：
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// 输出：[9,4]
//
// 说明：
//
// 输出结果中的每个元素一定是唯一的。
// 我们可以不考虑输出结果的顺序。
//
// Related Topics 数组 哈希表 双指针 二分查找 排序
// 👍 385 👎 0


import com.alibaba.fastjson.JSON;
import org.apache.hadoop.util.hash.Hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author yanghong
 */
public class Intersection349 {

    public static int[] intersection(int[] nums1, int[] nums2) {

        List<Integer> nums1List = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        Set<Integer> containEl = new HashSet<>();

        for (int num : nums2) {
            if (nums1List.contains(num)) {
                containEl.add(num);
            }
        }

        int[] result = new int[containEl.size()];
        int count = 0;
        for (Integer e : containEl) {
            result[count] = e;
            count++;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        System.out.println(JSON.toJSONString(intersection(nums1, nums2)));

    }
}
