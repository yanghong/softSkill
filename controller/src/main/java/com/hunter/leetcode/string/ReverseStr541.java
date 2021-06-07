package com.hunter.leetcode.string;

//给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
//
// 如果剩余字符少于 k 个，则将剩余字符全部反转。
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
//
// 示例:
//
// 输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
//
// 提示：
//
// 该字符串只包含小写英文字母。
// 给定字符串的长度和 k 在 [1, 10000] 范围内。
//
// Related Topics 字符串
// 👍 125 👎 0
/**
 * @author yanghong
 */
public class ReverseStr541 {

    public static String reverseStr(String s, int k) {
        StringBuilder result= new StringBuilder();
        for(int m=0;m<s.length();m+=2*k)
        {
            if(s.length()-m<2*k)
            {
                if(s.length()-m<k) {
                    result.append(new StringBuilder(s.substring(m)).reverse().toString());
                } else {
                    result.append(new StringBuilder(s.substring(m, m + k)).reverse().toString()).append(s.substring(m + k));
                }
            } else {
                result.append(new StringBuilder(s.substring(m, m + k)).reverse().toString()).append(s.substring(m + k, m + 2 * k));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {

        String s = "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
        int k = 39;

        System.out.println(reverseStr(s, k));

    }
}
