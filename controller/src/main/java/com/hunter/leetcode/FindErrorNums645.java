package com.hunter.leetcode;

//集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有
//一个数字重复 。
//
// 给定一个数组 nums 代表了集合 S 发生错误后的结果。
//
// 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
//
// 示例 1：
//
//
//输入：nums = [1,2,2,4]
//输出：[2,3]
//
//
// 示例 2：
//
//输入：nums = [1,1]
//输出：[1,2]
//
// 提示：
//
// 2 <= nums.length <= 104
// 1 <= nums[i] <= 104
//
// Related Topics 位运算 数组 哈希表 排序
// 👍 181 👎 0

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yanghong
 */
public class FindErrorNums645 {

    public static int[] findErrorNums(int[] nums) {

        int[] errorNums = new int[2];
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 1; i <= n; i++) {
            int count = map.getOrDefault(i, 0);
            if (count == 2) {
                errorNums[0] = i;
            } else if (count == 0) {
                errorNums[1] = i;
            }
        }
        return errorNums;
    }

    public static void main(String[] args) {

        int[] nums = {3,2,2};

        int[] errorNums = findErrorNums(nums);

        System.out.println(JSON.toJSONString(errorNums));

    }
}
