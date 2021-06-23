package com.hunter.leetcode.string;
//输入一个字符串，打印出该字符串中字符的所有排列。
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
//
// 示例:
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
//
// 限制：
//
// 1 <= s 的长度 <= 8
// Related Topics 回溯算法
// 👍 362 👎 0

import org.apache.avro.generic.GenericData;

import java.util.*;

/**
 * @author yanghong
 */
public class PermutationOffer38 {

    static List<String> res;
    static boolean[] vis;

    public static String[] permutation(String s) {
        int n = s.length();
        res = new ArrayList<String>();
        vis = new boolean[n];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder perm = new StringBuilder();
        backtrack(arr, 0, n, perm);
        int size = res.size();
        String[] recArr = new String[size];
        for (int i = 0; i < size; i++) {
            recArr[i] = res.get(i);
        }
        return recArr;
    }

    private static void backtrack(char[] arr, int i, int n, StringBuilder perm) {
        if (i==n) {
            res.add(perm.toString());
        }
        for (int j = 0; j < n; j++) {
            if (vis[j] || (j > 0 && !vis[j - 1] && arr[j - 1] == arr[j])) {
                continue;
            }
            vis[j] = true;
            perm.append(arr[j]);
            backtrack(arr, i + 1, n, perm);
            perm.deleteCharAt(perm.length() - 1);
            vis[j] = false;
        }
    }

    public static void main(String[] args) {

    }
}
