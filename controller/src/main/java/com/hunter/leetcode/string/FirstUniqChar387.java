package com.hunter.leetcode.string;
//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
//
//
// 示例：
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
//
//
//
//
// 提示：你可以假定该字符串只包含小写字母。
// Related Topics 哈希表 字符串
// 👍 399 👎 0

/**
 * @author yanghong
 */
public class FirstUniqChar387 {

    public static int firstUniqChar(String s) {
        if (null == s) {
            return -1;
        }

        for (int i = 0; i < s.length(); i++) {

            String front = "";
            if (i > 0) {
                front = s.substring(0, i);
            }

            String target = front + s.substring(i + 1);

            if (!target.contains(String.valueOf(s.charAt(i)))) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "ttaasfafasdf";

        System.out.println(firstUniqChar(s));
    }
}
