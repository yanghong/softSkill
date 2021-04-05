package com.hunter.leetcode.search;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法
// 👍 1266 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yanghong
 */
public class AllSort46 {

    private static List<List<Integer>> listList;

    public static List<List<Integer>> permute(int[] nums) {

        listList = new ArrayList<>();
        permute(nums, new ArrayList<>());
        return listList;
    }

    private static void permute(int[] nums, List<Integer> list) {

        int n = nums.length;

        if(list.size() == n) {
            listList.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if(list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            permute(nums, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = permute(nums);
        System.out.println(result);
    }
}
