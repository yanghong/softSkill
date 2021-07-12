package com.hunter.leetcode;

//给定两个数组，编写一个函数来计算它们的交集。
//
// 示例 1：
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
//
// 示例 2:
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9]
//
// 说明：
//
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
// 我们可以不考虑输出结果的顺序。
//
// 进阶：
//
// 如果给定的数组已经排好序呢？你将如何优化你的算法？
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
//
// Related Topics 数组 哈希表 双指针 二分查找 排序
// 👍 512 👎 0

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Arrays.copyOfRange(intersection, 0, index);
 * @author yanghong
 */
public class Intersect350 {

    public static int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> nums1List = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> nums2List = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        List<Integer> containEl1 = new ArrayList<>();
        List<Integer> containEl2 = new ArrayList<>();
        List<Integer> containEl = new ArrayList<>();

        for (int num : nums2) {
            if (nums1List.contains(num)) {
                containEl1.add(num);
            }
        }

        for (int num : nums1) {
            if (nums2List.contains(num)) {
                containEl2.add(num);
            }
        }

        if (containEl1.size() > containEl2.size()) {
            containEl = containEl2;
        } else {
            containEl = containEl1;
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

        int[] nums1 = {61,24,20,58,95,53,17,32,45,85,70,20,83,62,35,89,5,95,12,86,58,77,30,64,46,13,5,92,67,40,20,38,31,18,89,85,7,30,67,34,62,35,47,98,3,41,53,26,66,40,54,44,57,46,70,60,4,63,82,42,65,59,17,98,29,72,1,96,82,66,98,6,92,31,43,81,88,60,10,55,66,82,0,79,11,81};
        int[] nums2 = {5,25,4,39,57,49,93,79,7,8,49,89,2,7,73,88,45,15,34,92,84,38,85,34,16,6,99,0,2,36,68,52,73,50,77,44,61,48};

        System.out.println(JSON.toJSONString(intersect(nums1, nums2)));
        // 5,4,57,79,7,89,7,88,45,34,92,38,85,34,6,0,77,44,61
        // 5,4,57,79,7,89,  88,45,34,92,38,85,   6,0,77,44,61

    }
}
