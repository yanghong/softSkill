package com.hunter.leetcode.string;
//实现 strStr() 函数。
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
// 果不存在，则返回 -1 。
//
// 说明：
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
//
// 示例 1：
//
//输入：haystack = "hello", needle = "ll"
//输出：2
//
// 示例 2：
//
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
//
// 示例 3：
//
//输入：haystack = "", needle = ""
//输出：0
//
// 提示：
//
// 0 <= haystack.length, needle.length <= 5 * 104
// haystack 和 needle 仅由小写英文字符组成
//
// Related Topics 双指针 字符串
// 👍 926 👎 0

/**
 * @author yanghong
 */
public class StrStr28 {

    public static int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        // 注意临界值判断
        if (null == haystack || null == needle || "".equals(haystack) || needle.length() > haystack.length()) {
            return -1;
        }

        for (int i = 0; i < haystack.length(); i++) {
            if (needle.charAt(0) == haystack.charAt(i)) {
                String needleStr = needle.substring(0, needle.length());
                // 注意substring 使用时临界值判断
                if (i + needle.length() > haystack.length()) {
                    return -1;
                }
                String haystackStr = haystack.substring(i, i + needle.length());
                if (needleStr.equals(haystackStr)) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        // "aaa" "aaaa"
        // "mississippi" "issipi"
        String haystack = "mississippi";
        String needle = "issipi";

        System.out.println(strStr(haystack, needle));
    }
}
