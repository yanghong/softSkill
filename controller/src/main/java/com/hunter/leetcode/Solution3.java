package com.hunter.leetcode;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window

import java.util.HashSet;
import java.util.Set;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/10/25 17:17
 */
public class Solution3 {

    public static int lengthOfLongestSubstring(String s) {

        if("".equals(s)) {
            return 0;
        }

        int count = 1;
        Set<Character> resultSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++ ) {
            for (int j = i + 1; j < s.length(); j++ ) {
                if (resultSet.contains(s.charAt(j))) {
                    resultSet.clear();
                    i = i + 1;
                    j = i;
                } else {
                    resultSet.add(s.charAt(i));
                    resultSet.add(s.charAt(j));
                }
                count = Math.max(count, resultSet.size());
            }
        }

        return count;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }
}
