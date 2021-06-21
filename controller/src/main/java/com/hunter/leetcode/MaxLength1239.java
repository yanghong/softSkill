package com.hunter.leetcode;
// 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，
// 如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
//
// 请返回所有可行解 s 中最长长度。
//
// 示例 1：
//
// 输入：arr = ["un","iq","ue"]
// 输出：4
// 解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
//
// 示例 2：
//
// 输入：arr = ["cha","r","act","ers"]
// 输出：6
// 解释：可能的解答有 "chaers" 和 "acters"。
//
// 示例 3：
//
// 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
// 输出：26
//
// 提示：
//
// 1 <= arr.length <= 16
// 1 <= arr[i].length <= 26
// arr[i] 中只含有小写英文字母
//
// Related Topics 位运算 回溯算法
// 👍 155 👎 0

import java.util.ArrayList;
import java.util.List;
/**
 * @author yanghong
 */
public class MaxLength1239 {

    private static int ans = 0;

    public static int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<Integer>();
        for (String s : arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); ++i) {
                int ch = s.charAt(i) - 'a';
                if (((mask >> ch) & 1) != 0) { // 若 mask 已有 ch，则说明 s 含有重复字母，无法构成可行解
                    mask = 0;
                    break;
                }
                mask |= 1 << ch; // 将 ch 加入 mask 中
            }
            if (mask > 0) {
                masks.add(mask);
            }
        }

        backtrack(masks, 0, 0);
        return ans;
    }

    public static void backtrack(List<Integer> masks, int pos, int mask) {
        if (pos == masks.size()) {
            ans = Math.max(ans, Integer.bitCount(mask));
            return;
        }
        if ((mask & masks.get(pos)) == 0) { // mask 和 masks[pos] 无公共元素
            backtrack(masks, pos + 1, mask | masks.get(pos));
        }
        backtrack(masks, pos + 1, mask);
    }

    public static void main(String[] args) {

    }
}
